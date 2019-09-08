package com.kryptokrauts.aeternity.sdk.service.aeternity.impl;

import com.kryptokrauts.aeternity.generated.api.ExternalApiImpl;
import com.kryptokrauts.aeternity.generated.api.rxjava.ExternalApi;
import com.kryptokrauts.aeternity.sdk.service.account.AccountService;
import com.kryptokrauts.aeternity.sdk.service.account.impl.AccountServiceImpl;
import com.kryptokrauts.aeternity.sdk.service.aens.NameService;
import com.kryptokrauts.aeternity.sdk.service.aens.impl.NameServiceImpl;
import com.kryptokrauts.aeternity.sdk.service.aeternity.AeternityServiceConfiguration;
import com.kryptokrauts.aeternity.sdk.service.compiler.CompilerService;
import com.kryptokrauts.aeternity.sdk.service.compiler.impl.SophiaCompilerServiceImpl;
import com.kryptokrauts.aeternity.sdk.service.info.InfoService;
import com.kryptokrauts.aeternity.sdk.service.info.impl.InfoServiceImpl;
import com.kryptokrauts.aeternity.sdk.service.oracle.OracleService;
import com.kryptokrauts.aeternity.sdk.service.oracle.impl.OracleServiceImpl;
import com.kryptokrauts.aeternity.sdk.service.transaction.TransactionService;
import com.kryptokrauts.aeternity.sdk.service.transaction.impl.TransactionServiceImpl;
import com.kryptokrauts.sophia.compiler.generated.api.DefaultApiImpl;
import com.kryptokrauts.sophia.compiler.generated.api.rxjava.DefaultApi;

import lombok.NonNull;

public class AeternityService {

	@NonNull
	protected AeternityServiceConfiguration config;

	private ExternalApi externalApi;

	private DefaultApi compilerApi;

	public TransactionService transactions;

	public AccountService accounts;

	public CompilerService compiler;

	public InfoService info;

	public NameService names;

	public OracleService oracles;

	public AeternityService(AeternityServiceConfiguration config) {
		this.config = config;
		this.externalApi = new ExternalApi(new ExternalApiImpl(config.getApiClient()));
		this.compilerApi = new DefaultApi(new DefaultApiImpl(config.getCompilerApiClient()));
		this.transactions = new TransactionServiceImpl(this.config, this.externalApi, this.compilerApi);
		this.accounts = new AccountServiceImpl(this.config, this.externalApi);
		this.compiler = new SophiaCompilerServiceImpl(this.config, this.compilerApi);
		this.info = new InfoServiceImpl(this.config, this.externalApi);
		this.names = new NameServiceImpl(this.config, this.externalApi);
		this.oracles = new OracleServiceImpl(this.config, this.externalApi);
	}
}
