package com.github.toshiyag.cryptors.common;

public interface Decryptor {
    Message<Text.Plain> decrypt(Message<Text.Encrypted> plain);
}
