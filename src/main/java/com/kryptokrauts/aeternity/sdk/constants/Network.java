package com.kryptokrauts.aeternity.sdk.constants;

/**
 * needed for transaction-signature
 * https://github.com/aeternity/protocol/blob/master/consensus/consensus.md#transaction-signature
 */
public enum Network {
  LOCAL_IRIS_NETWORK("local_iris_testnet"),
  DEVNET("ae_devnet"),
  TESTNET("ae_uat"),
  MAINNET("ae_mainnet");

  private String id;

  Network(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }
}
