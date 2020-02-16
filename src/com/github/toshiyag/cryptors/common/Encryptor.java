package com.github.toshiyag.cryptors.common;

public interface Encryptor {
    Message<Text.Encrypted> encrypt(Message<Text.Plain> plain);
}
