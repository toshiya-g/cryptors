package com.github.toshiyag.cryptors.aes;


import com.github.toshiyag.cryptors.common.CryptKey;

import javax.crypto.SecretKey;

public class AESCryptKey implements CryptKey<SecretKey> {

    private final SecretKey key;

    AESCryptKey(SecretKey key) {
        this.key = key;
    }

    @Override
    public SecretKey getKey() {
        return this.key;
    }
}
