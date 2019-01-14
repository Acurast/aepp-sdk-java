package com.kryptokrauts.aeternity.sdk.domain.secret.impl;

import com.kryptokrauts.aeternity.sdk.domain.secret.KeyPair;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RawKeyPair implements KeyPair<byte[]> {
    private byte[] publicKey;
    private byte[] privateKey;

    @Builder
    public RawKeyPair(final byte[] publicKey, final byte[] privateKey) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }
}
