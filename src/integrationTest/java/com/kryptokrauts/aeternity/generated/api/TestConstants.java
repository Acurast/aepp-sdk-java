package com.kryptokrauts.aeternity.generated.api;

import java.util.Arrays;
import java.util.List;

public interface TestConstants {

  String errorOccured = "error occured:";

  /** @see https://testnet.contracts.aepps.com/ */
  String testnetAccountPrivateKey =
      "a7a695f999b1872acb13d5b63a830a8ee060ba688a478a08c6e65dfad8a01cd70bb4ed7927f97b51e1bcb5e1340d12335b2a2b12c8bc5221d63c4bcb39d41e61";

  String testnetURL = "https://sdk-testnet.aepps.com/v2";

  String testContractSourceCode =
      "contract Identity =\n  type state = ()\n  function main(z : int) = z";

  String testContractFunction = "main";

  String testContractFunctionSophiaType = "int";

  String testContractFuntionParam = "42";

  List<String> testContractFunctionParams = Arrays.asList(testContractFuntionParam);

  String testContractByteCode =
      "cb_+QP1RgKgpVq1Ib2r2ug+UktHvfWSQ8P35HJQHM6qikqBu1DwgtT5Avv5ASqgaPJnYzj/UIg5q6R3Se/6i+h+8oTyB/s9mZhwHNU4h8WEbWFpbrjAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAKD//////////////////////////////////////////wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAuEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAIAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA+QHLoLnJVvKLMUmp9Zh6pQXz2hsiCcxXOSNABiu2wb2fn5nqhGluaXS4YAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAP//////////////////////////////////////////7kBQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAMAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAYAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAMAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAEA//////////////////////////////////////////8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA///////////////////////////////////////////uMxiAABkYgAAhJGAgIBRf7nJVvKLMUmp9Zh6pQXz2hsiCcxXOSNABiu2wb2fn5nqFGIAAMBXUIBRf2jyZ2M4/1CIOaukd0nv+ovofvKE8gf7PZmYcBzVOIfFFGIAAK9XUGABGVEAW2AAGVlgIAGQgVJgIJADYAOBUpBZYABRWVJgAFJgAPNbYACAUmAA81tZWWAgAZCBUmAgkANgABlZYCABkIFSYCCQA2ADgVKBUpBWW2AgAVFRWVCAkVBQgJBQkFZbUFCCkVBQYgAAjFaFMy4wLjDZUhWH";

  String testContractCallData =
      "cb_AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACC5yVbyizFJqfWYeqUF89obIgnMVzkjQAYrtsG9n5+Z6gAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAnHQYrA==";

  String binaryTxDevnet =
      "0xF9049B2A01A10175EE9825AD630963482BB1939A212A0E535883C6B4D7804E40287E1F556DA27201B903F8F903F54602A0A55AB521BDABDAE83E524B47BDF59243C3F7E472501CCEAA8A4A81BB50F082D4F902FBF9012AA068F2676338FF508839ABA47749EFFA8BE87EF284F207FB3D9998701CD53887C5846D61696EB8C000000000000000000000000000000000000000000000000000000000000000200000000000000000000000000000000000000000000000000000000000000003000000000000000000000000000000000000000000000000000000000000006000000000000000000000000000000000000000000000000000000000000000A0FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF0000000000000000000000000000000000000000000000000000000000000000B84000000000000000000000000000000000000000000000000000000000000000200000000000000000000000000000000000000000000000000000000000000000F901CBA0B9C956F28B3149A9F5987AA505F3DA1B2209CC57392340062BB6C1BD9F9F99EA84696E6974B86000000000000000000000000000000000000000000000000000000000000000200000000000000000000000000000000000000000000000000000000000000003FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFB9014000000000000000000000000000000000000000000000000000000000000000200000000000000000000000000000000000000000000000000000000000000003000000000000000000000000000000000000000000000000000000000000006000000000000000000000000000000000000000000000000000000000000000A000000000000000000000000000000000000000000000000000000000000000C000000000000000000000000000000000000000000000000000000000000000050000000000000000000000000000000000000000000000000000000000000100FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF0000000000000000000000000000000000000000000000000000000000000003FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFB8CC620000646200008491808080517FB9C956F28B3149A9F5987AA505F3DA1B2209CC57392340062BB6C1BD9F9F99EA14620000C0575080517F68F2676338FF508839ABA47749EFFA8BE87EF284F207FB3D9998701CD53887C514620000AF575060011951005B600019596020019081526020900360038152905960005159526000526000F35B600080526000F35B595960200190815260209003600019596020019081526020900360038152815290565B602001515159508091505080905090565B5050829150506200008C5685332E302E30830400018703E739B7076800824E2000008203E8844190AB00B8600000000000000000000000000000000000000000000000000000000000000020B9C956F28B3149A9F5987AA505F3DA1B2209CC57392340062BB6C1BD9F9F99EA0000000000000000000000000000000000000000000000000000000000000000";

  String encodedServiceCall =
      "cb_AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACBo8mdjOP9QiDmrpHdJ7/qL6H7yhPIH+z2ZmHAc1TiHxQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACo7dbVl";

  String encodedServiceCallAnswer = "cb_AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACr8s/aY";

  String serviceCallAnswerJSON = "{type=word, value=42}";
}