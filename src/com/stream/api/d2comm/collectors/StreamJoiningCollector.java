package com.stream.api.d2comm.collectors;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamJoiningCollector {

    public static void main(String[] args) {
        joining();
        joiningWithPrefixSuffix();
    }

    private static void joiningWithPrefixSuffix() {
        String result = Stream.of(1, 2, 3)
                .map(String::valueOf)
                .collect(Collectors.joining("-", "<", ">"));

        System.out.println(result);
    }

    private static void joining() {
        String result = Stream.of(1, 2, 3)
                .map(String::valueOf)
                .collect(Collectors.joining("-"));

        System.out.println(result);
    }
}
