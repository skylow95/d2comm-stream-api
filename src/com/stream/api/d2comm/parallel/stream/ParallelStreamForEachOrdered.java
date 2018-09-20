package com.stream.api.d2comm.parallel.stream;

import java.util.stream.IntStream;

public class ParallelStreamForEachOrdered {

    public static void main(String[] args) {
        IntStream.range(0, 10000)
                .parallel()
                .filter(x -> x % 10 == 0)
                .map(x -> x / 10)
                .forEach(System.out::println);

        System.out.println("###ORDERED stream:");

        IntStream.range(0, 10000)
                .parallel()
                .filter(x -> x % 10 == 0)
                .map(x -> x / 10)
                .forEachOrdered(System.out::println);
    }

}
