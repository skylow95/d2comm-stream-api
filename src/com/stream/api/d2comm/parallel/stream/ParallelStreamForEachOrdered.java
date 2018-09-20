package com.stream.api.d2comm.parallel.stream;

import java.util.stream.IntStream;

public class ParallelStreamForEachOrdered {

    public static void main(String[] args) {
        IntStream.range(0, 100000)
                .parallel()
                .filter(x -> x % 10000 == 0)
                .map(x -> x / 10000)
                .forEach(System.out::println);

        System.out.println("###ORDERED stream:");

        IntStream.range(0, 100000)
                .parallel()
                .filter(x -> x % 10000 == 0)
                .map(x -> x / 10000)
                .forEachOrdered(System.out::println);
    }

}
