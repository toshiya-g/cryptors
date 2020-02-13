package com.github.toshiyag.cryptors.common;

public interface Decryptor {
    Message<Sentence.Plain> decrypt(Message<Sentence.Encrypted> plain);
}
