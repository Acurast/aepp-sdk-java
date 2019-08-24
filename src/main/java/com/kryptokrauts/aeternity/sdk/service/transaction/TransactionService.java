package com.kryptokrauts.aeternity.sdk.service.transaction;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.bouncycastle.crypto.CryptoException;

import com.kryptokrauts.aeternity.generated.model.DryRunResults;
import com.kryptokrauts.aeternity.generated.model.PostTxResponse;
import com.kryptokrauts.aeternity.generated.model.Tx;
import com.kryptokrauts.aeternity.generated.model.UnsignedTx;
import com.kryptokrauts.aeternity.sdk.service.transaction.type.model.AbstractTransactionModel;

import io.reactivex.Single;

public interface TransactionService {

	Single<PostTxResponse> postTransaction(Tx tx);

	/**
	 * @param unsignedTx
	 * @param privateKey
	 * @return signed and encoded transaction
	 * @throws CryptoException
	 */
	Tx signTransaction(UnsignedTx unsignedTx, String privateKey) throws CryptoException;

	/**
	 * creates an unsignedTx object for further processing and especially abstracts
	 * the fee calculation for this transaction
	 *
	 * @param tx transaction typed model, one of {link AbstractTransaction}
	 * @return a single-wrapped unsignedTx object
	 */
	Single<UnsignedTx> createUnsignedTransaction(AbstractTransactionModel<?> tx);

	/**
	 * dry run unsigned transactions to estimate gas (!) please make sure to use
	 * implementations of {@link List} to ensure correct order of transactions
	 * called by accounts
	 *
	 * @param accounts
	 * @param block
	 * @param unsignedTransactions
	 * @return
	 */
	Single<DryRunResults> dryRunTransactions(List<Map<AccountParameter, Object>> accounts, BigInteger block,
			List<UnsignedTx> unsignedTransactions);

	Single<PostTxResponse> postTransaction(AbstractTransactionModel<?> tx) throws CryptoException;

	/**
	 * @param transaction object
	 * @return the hash from a signed and encoded transaction
	 */
	String computeTxHash(AbstractTransactionModel<?> tx) throws CryptoException;

}
