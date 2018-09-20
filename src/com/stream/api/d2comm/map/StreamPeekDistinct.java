package com.stream.api.d2comm.map;

import java.util.stream.Stream;

public class StreamPeekDistinct {

    public static void main(String[] args) {
        Stream.of(0, 3, 0, 0, 5)
                .peek(x -> System.out.format("before distinct: %d%n", x))
                .distinct()
                .peek(x -> System.out.format("after distinct: %d%n", x))
                .map(x -> x * x)
                .forEach(x -> System.out.format("after map: %d%n", x));
    }

}
