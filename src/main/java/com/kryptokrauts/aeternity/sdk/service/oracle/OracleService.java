package com.kryptokrauts.aeternity.sdk.service.oracle;

import com.kryptokrauts.aeternity.generated.model.OracleQueries;
import com.kryptokrauts.aeternity.generated.model.OracleQuery;
import com.kryptokrauts.aeternity.generated.model.RegisteredOracle;
import com.kryptokrauts.aeternity.sdk.service.name.domain.OracleQueriesResult;
import com.kryptokrauts.aeternity.sdk.service.name.domain.OracleQueryResult;
import com.kryptokrauts.aeternity.sdk.service.oracle.domain.RegisteredOracleResult;
import io.reactivex.Single;
import java.math.BigInteger;
import java.util.Optional;

public interface OracleService {

  /**
   * Get an oracle by its public key
   *
   * @param publicKey The public key of the oracle (required)
   * @return Asynchronous result handler (RxJava Single) for {@link RegisteredOracle}
   */
  Single<RegisteredOracleResult> asyncGetRegisteredOracle(String publicKey);

  RegisteredOracleResult blockingGetRegisteredOracle(String publicKey);

  /**
   * Get oracle queries by public key
   *
   * @param publicKey The public key of the oracle (required)
   * @param from Last query id in previous page (optional)
   * @param limit Max number of oracle queries (optional)
   * @param type The type of a query: open, closed or all (optional)
   * @return Asynchronous result handler (RxJava Single) for {@link OracleQueries}
   */
  Single<OracleQueriesResult> asyncGetOracleQueries(
      String publicKey, Optional<String> from, Optional<BigInteger> limit, Optional<String> type);

  OracleQueriesResult blockingGetOracleQueries(
      String publicKey, Optional<String> from, Optional<BigInteger> limit, Optional<String> type);

  /**
   * Get an oracle query by public key and query ID
   *
   * @param publicKey The public key of the oracle (required)
   * @param queryId The ID of the query (required)
   * @return Asynchronous result handler (RxJava Single) for {@link OracleQuery}
   */
  Single<OracleQueryResult> asyncGetOracleQuery(String publicKey, String queryId);

  OracleQueryResult blockingGetOracleQuery(String publicKey, String queryId);
}
