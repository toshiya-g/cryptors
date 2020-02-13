package com.github.toshiyag.cryptors.aes;


import com.github.toshiyag.cryptors.common.Decryptor;
import com.github.toshiyag.cryptors.common.Encryptor;
import com.github.toshiyag.cryptors.common.Message;
import com.github.toshiyag.cryptors.common.Sentence;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;


public class AESCrypt implements Encryptor, Decryptor {

    private static final String CIPHER = "AES";
    private static final String ALGORITHM = "AES_128/CBC/NOPADDING";

    private final SecretKeySpec secretKeySpec;
    private final IvParameterSpec ivParameterSpec;

    public AESCrypt(final AESCryptKey key) throws NoSuchAlgorithmException {
        final SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        final byte[] vector = new byte[16];
        random.nextBytes(vector);

        this.secretKeySpec = new SecretKeySpec(key.getKey().getEncoded(), AESCrypt.CIPHER);
        this.ivParameterSpec = new IvParameterSpec(vector);
    }

    @Override
    public Message<Sentence.Plain> decrypt(final Message<Sentence.Encrypted> encryptedMessage) {
        final Base64.Decoder decoder = Base64.getDecoder();
        final byte[] messageBytes = decoder.decode(encryptedMessage.toString().getBytes());
        final byte[] decryptedBytes = crypt(CryptMethod.DECRYPT, this.secretKeySpec, this.ivParameterSpec, messageBytes);
        return Message.plain(new String(decryptedBytes, StandardCharsets.UTF_8));
    }

    @Override
    public Message<Sentence.Encrypted> encrypt(final Message<Sentence.Plain> plainMessage) {
        final byte[] messageBytes = plainMessage.toString().getBytes();
        final byte[] encryptedBytes = crypt(CryptMethod.ENCRYPT, this.secretKeySpec, this.ivParameterSpec, messageBytes);
        final Base64.Encoder encoder = Base64.getEncoder();
        return Message.encrypted(encoder.encodeToString(encryptedBytes));
    }

    private enum CryptMethod {
        ENCRYPT(Cipher.ENCRYPT_MODE),
        DECRYPT(Cipher.DECRYPT_MODE);

        final int mode;

        CryptMethod(int mode) {
            this.mode = mode;
        }
    }

    private static byte[] crypt
            (final CryptMethod cryptMethod
            , final SecretKeySpec secretKeySpec
            , final IvParameterSpec ivParameterSpec
            , final byte[] messageBytes) {
        try {
            final Cipher cipher = Cipher.getInstance(AESCrypt.ALGORITHM);
            cipher.init(cryptMethod.mode, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(messageBytes);
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }
}
