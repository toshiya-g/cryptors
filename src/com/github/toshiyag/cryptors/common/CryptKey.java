package com.github.toshiyag.cryptors.common;

import java.io.Serializable;

public interface CryptKey<T extends Serializable> {
    T getKey();
}
