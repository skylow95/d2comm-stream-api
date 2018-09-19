package com.stream.api.d2comm;

import java.util.stream.Stream;

public class StreamToArray {

    public static void main(String[] args) {
        Object[] objects = Stream.of("a", "b", "c", "d")
                .toArray();

        String[] elements = Stream.of("a", "b", "c", "d")
                .toArray(String[]::new);
    }

}
