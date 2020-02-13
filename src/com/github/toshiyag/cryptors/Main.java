package com.github.toshiyag.cryptors;


import com.github.toshiyag.cryptors.aes.AESCrypt;
import com.github.toshiyag.cryptors.aes.AESCryptKey;
import com.github.toshiyag.cryptors.aes.AESKeyGenerator;
import com.github.toshiyag.cryptors.common.KeyGenerator;
import com.github.toshiyag.cryptors.common.Message;
import com.github.toshiyag.cryptors.common.Sentence;

import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        final KeyGenerator<AESCryptKey> generator = new AESKeyGenerator();
        final AESCryptKey aesCryptKey = generator.genKey();
        final AESCrypt cryptor = new AESCrypt(aesCryptKey);

        final Message<Sentence.Plain> plainMessage = Message.plain("hogehogehogehoge");
        final Message<Sentence.Encrypted> encryptedMessage = cryptor.encrypt(plainMessage);

        System.out.println(encryptedMessage.toString());
        System.out.println(cryptor.decrypt(encryptedMessage));
    }
}
