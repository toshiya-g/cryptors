package com.github.toshiyag.cryptors.common;

public interface Sentence {

    final class Plain implements Sentence {
        private Plain() {}
    }

    final class Encrypted implements Sentence {
        private Encrypted() {}
    }
}
