package com.stream.api.d2comm.map;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMapCatchException {

    public static void main(String[] args) {
        List<Integer> integerStream = Arrays.asList(Stream.of(1, 2, 3).toArray(Integer[]::new));
        List<Integer> scale = scale(integerStream, 1);
        scale.forEach(System.out::println);
        scale(integerStream, 0);

        Stream.of(120, 410, 85, 32, 314, 12)
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
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
