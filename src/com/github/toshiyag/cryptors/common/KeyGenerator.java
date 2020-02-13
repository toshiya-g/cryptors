package com.github.toshiyag.cryptors.common;

public interface KeyGenerator<T extends CryptKey> {
    T genKey();
}
