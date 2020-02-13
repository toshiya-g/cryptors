package com.github.toshiyag.cryptors.common;


public interface Message<T extends Sentence> {

    String toString();
    Class<T> messageType();

    static Message<Sentence.Plain> plain(final String sentence) {
        return new Message<Sentence.Plain>() {
            @Override
            public String toString() {
                return sentence;
            }

            @Override
            public Class<Sentence.Plain> messageType() {
                return Sentence.Plain.class;
            }
        };
    }

    static Message<Sentence.Encrypted> encrypted(final String sentence) {
        return new Message<Sentence.Encrypted>() {
            @Override
            public String toString() {
                return sentence;
            }

            @Override
            public Class<Sentence.Encrypted> messageType() {
                return Sentence.Encrypted.class;
            }
        };
    }
}
