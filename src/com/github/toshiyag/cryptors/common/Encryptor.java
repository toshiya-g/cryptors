package com.github.toshiyag.cryptors.common;

public interface Encryptor {
    Message<Sentence.Encrypted> encrypt(Message<Sentence.Plain> plain);
}
