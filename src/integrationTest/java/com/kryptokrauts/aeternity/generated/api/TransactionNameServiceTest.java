package com.kryptokrauts.aeternity.generated.api;

import com.kryptokrauts.aeternity.generated.model.Account;
import com.kryptokrauts.aeternity.generated.model.PostTxResponse;
import com.kryptokrauts.aeternity.generated.model.Tx;
import com.kryptokrauts.aeternity.generated.model.UnsignedTx;
import com.kryptokrauts.aeternity.sdk.domain.secret.impl.BaseKeyPair;
import com.kryptokrauts.aeternity.sdk.service.transaction.type.AbstractTransaction;
import com.kryptokrauts.aeternity.sdk.util.CryptoUtils;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import java.math.BigInteger;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TransactionNameServiceTest extends BaseTest {

  BaseKeyPair baseKeyPair;
  String validDomain = "kryptokrauts.test";
  String invalidDomain = "kryptokrauts";

  @Before
  public void initBeforeTest() {
    baseKeyPair = keyPairService.generateBaseKeyPairFromSecret(BENEFICIARY_PRIVATE_KEY);
  }

  /**
   * create an unsigned native namepreclaim transaction
   *
   * @param context
   */
  @Test
  public void buildNativeNamePreclaimTransactionTest(TestContext context) {
    Async async = context.async();

    String sender = keyPairService.generateBaseKeyPair().getPublicKey();
    BigInteger salt = CryptoUtils.generateSalt();
    BigInteger nonce = BigInteger.valueOf(1);
    BigInteger ttl = BigInteger.valueOf(100);

    AbstractTransaction<?> namePreclaimTx =
        transactionServiceNative
            .getTransactionFactory()
            .createNamePreclaimTransaction(sender, validDomain, salt, nonce, ttl);
    UnsignedTx unsignedTxNative =
        transactionServiceNative.createUnsignedTransaction(namePreclaimTx).blockingGet();

    Single<UnsignedTx> unsignedTx =
        transactionServiceDebug.createUnsignedTransaction(namePreclaimTx);
    unsignedTx.subscribe(
        it -> {
          context.assertEquals(it, unsignedTxNative);
          async.complete();
        },
        throwable -> context.fail(throwable));
  }

  /**
   * this test succeeds but currently the NameClaimTx is not getting mined we need to figure out why
   *
   * @param context
   */
  @Test
  public void postNamePreclaimTxTest(TestContext context) {
    Async async = context.async();
    BaseKeyPair keyPair = keyPairService.generateBaseKeyPairFromSecret(BENEFICIARY_PRIVATE_KEY);
    rule.vertx()
        .executeBlocking(
            future -> {
              try {
                Single<Account> accountSingle = accountService.getAccount(keyPair.getPublicKey());
                TestObserver<Account> accountTestObserver = accountSingle.test();
                accountTestObserver.awaitTerminalEvent();
                Account account = accountTestObserver.values().get(0);
                BigInteger salt = CryptoUtils.generateSalt();
                BigInteger nonce = account.getNonce().add(BigInteger.ONE);
                BigInteger ttl = BigInteger.ZERO;

                AbstractTransaction<?> namePreclaimTx =
                    transactionServiceNative
                        .getTransactionFactory()
                        .createNamePreclaimTransaction(
                            keyPair.getPublicKey(), validDomain, salt, nonce, ttl);
                UnsignedTx unsignedTx =
                    transactionServiceNative
                        .createUnsignedTransaction(namePreclaimTx)
                        .blockingGet();
                Tx signedTx =
                    transactionServiceNative.signTransaction(unsignedTx, keyPair.getPrivateKey());
                _logger.info("Signed NamePreclaimTx: " + signedTx.getTx());

                Single<PostTxResponse> postTxResponseSingle =
                    transactionServiceNative.postTransaction(signedTx);
                TestObserver<PostTxResponse> postTxResponseTestObserver =
                    postTxResponseSingle.test();
                postTxResponseTestObserver.awaitTerminalEvent();
                PostTxResponse postTxResponse = postTxResponseTestObserver.values().get(0);
                _logger.info("NamePreclaimTx hash: " + postTxResponse.getTxHash());
                context.assertEquals(
                    postTxResponse.getTxHash(),
                    transactionServiceNative.computeTxHash(signedTx.getTx()));

                AbstractTransaction<?> nameClaimTx =
                    transactionServiceNative
                        .getTransactionFactory()
                        .createNameClaimTransaction(
                            keyPair.getPublicKey(),
                            validDomain,
                            salt,
                            nonce.add(BigInteger.ONE),
                            ttl);
                unsignedTx =
                    transactionServiceNative.createUnsignedTransaction(nameClaimTx).blockingGet();
                signedTx =
                    transactionServiceNative.signTransaction(unsignedTx, keyPair.getPrivateKey());
                _logger.info("Signed NameClaimTx: " + signedTx.getTx());
                postTxResponseSingle = transactionServiceNative.postTransaction(signedTx);
                postTxResponseTestObserver = postTxResponseSingle.test();
                postTxResponseTestObserver.awaitTerminalEvent();
                postTxResponse = postTxResponseTestObserver.values().get(0);
                _logger.info("NameClaimTx hash: " + postTxResponse.getTxHash());
                context.assertEquals(
                    postTxResponse.getTxHash(),
                    transactionServiceNative.computeTxHash(signedTx.getTx()));

              } catch (Exception e) {
                context.fail(e);
              }
              future.complete();
            },
            success -> async.complete());
  }
}
