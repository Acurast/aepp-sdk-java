package com.kryptokrauts.aeternity.generated.api;

import com.kryptokrauts.aeternity.generated.model.KeyBlock;
import com.kryptokrauts.aeternity.sdk.service.chain.ChainServiceFactory;
import io.reactivex.Single;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import org.junit.Assert;
import org.junit.Test;

public class ChainApiTest extends BaseTest {

  @Test
  public void getCurrentKeyBlockTest(TestContext context) {
    Async async = context.async();
    Single<KeyBlock> keyBlockObservable = chainService.getCurrentKeyBlock();
    keyBlockObservable.subscribe(
        keyBlock -> {
          context.assertTrue(keyBlock.getHeight().longValue() > 0);
          async.complete();
        },
        throwable -> {
          _logger.error(TestConstants.errorOccured, throwable);
          context.fail();
        });
  }

  @Test(expected = NullPointerException.class)
  public void testNullConfig() {
    new ChainServiceFactory().getService(null);
  }

  @Test
  public void getDefaultChainService() {
    Assert.assertNotNull(new ChainServiceFactory().getService());
  }
}
