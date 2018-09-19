package com.stream.api.d2comm.map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMapCatchException {

    public static void main(String[] args) {
        List<Integer> integerStream = Arrays.asList(Stream.of(1, 2, 3).toArray(Integer[]::new));
        scale(integerStream, 1);
        scale(integerStream, 0);
    }

    private static Integer divide(Integer value, Integer factor) {
        try {
            return value / factor;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return null;
    }

    static List<Integer> scale(List<Integer> values, Integer factor) {
        return values.stream()
                .map(n -> divide(n, factor))
                .collect(Collectors.toList());
    }
}
