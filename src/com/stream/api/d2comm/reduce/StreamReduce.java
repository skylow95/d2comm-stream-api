package com.stream.api.d2comm.reduce;

import java.util.stream.Stream;

public class StreamReduce {

    public static void main(String[] args) {
        int value = Stream.of(1, 2, 3, 4, 5, 6).reduce(0, (a, b) -> a + b);

        System.out.println(value);

        String result = Stream.of(1, 2, 3, 4, 5, 6).map(x -> Integer.toString(x)).reduce("", (a, b) -> a + b);

        System.out.println(result);
    }

}
