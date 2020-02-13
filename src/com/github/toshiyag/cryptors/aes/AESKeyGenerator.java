package com.github.toshiyag.cryptors.aes;


import com.github.toshiyag.cryptors.common.KeyGenerator;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class AESKeyGenerator implements KeyGenerator<AESCryptKey> {

    private static final int KEY_SIZE = 128;

    @Override
    public AESCryptKey genKey() {
        try {
            final javax.crypto.KeyGenerator keygen = javax.crypto.KeyGenerator.getInstance("AES");
            final SecureRandom random = new SecureRandom();
            keygen.init(AESKeyGenerator.KEY_SIZE, random);
            return new AESCryptKey(keygen.generateKey());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
