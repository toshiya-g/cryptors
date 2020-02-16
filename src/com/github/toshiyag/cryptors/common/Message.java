package com.github.toshiyag.cryptors.common;


public interface Message<T extends Text> {

    String toString();
    Class<T> messageType();

    static Message<Text.Plain> plain(final String sentence) {
        return new Message<Text.Plain>() {
            @Override
            public String toString() {
                return sentence;
            }

            @Override
            public Class<Text.Plain> messageType() {
                return Text.Plain.class;
            }
        };
    }

    static Message<Text.Encrypted> encrypted(final String sentence) {
        return new Message<Text.Encrypted>() {
            @Override
            public String toString() {
                return sentence;
            }

            @Override
            public Class<Text.Encrypted> messageType() {
                return Text.Encrypted.class;
            }
        };
    }
}
