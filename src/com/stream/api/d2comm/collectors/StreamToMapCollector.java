package com.stream.api.d2comm.collectors;

import com.stream.api.d2comm.domain.Phone;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamToMapCollector {

    public static void main(String[] args) {
        collectSimpleToMap();
        collectMergeToMap();
        collectFactoryToMap();
    }

    private static void collectSimpleToMap() {
        Stream<Phone> phoneStream = Stream.of(new Phone("iPhone 8", 54000),
                new Phone("Nokia 9", 45000),
                new Phone("Samsung Galaxy S9", 40000),
                new Phone("LG G6", 32000));


        Map<String, Integer> phones = phoneStream
                .collect(Collectors.toMap(
                        Phone::getName, // key
                        Phone::getPrice) // value
                );

        phones.forEach((key, value) -> System.out.println(key + " " + value));
    }

    private static void collectMergeToMap() {
        Stream<Phone> phoneStream = Stream.of(new Phone("iPhone 8", 54000),
                new Phone("Nokia 9", 45000),
                new Phone("Samsung Galaxy S9", 40000),
                new Phone("LG G6", 32000));


        Map<String, Integer> phones = phoneStream
                .collect(Collectors.toMap(
                        Phone::getName, // key
                        Phone::getPrice, // value
                        (a, b) -> a + b) // merge function
                );

        phones.forEach((key, value) -> System.out.println(key + " " + value));
    }

    private static void collectFactoryToMap() {
        Stream<Phone> phoneStream = Stream.of(new Phone("iPhone 8", 54000),
                new Phone("Nokia 9", 45000),
                new Phone("Samsung Galaxy S9", 40000),
                new Phone("LG G6", 32000));


        Map<String, Integer> phones = phoneStream
                .collect(Collectors.toMap(
                        Phone::getName, // key
                        Phone::getPrice, // value
                        (a, b) -> a + b, // merge function
                        LinkedHashMap::new) // result
                );

        phones.forEach((key, value) -> System.out.println(key + " " + value));
    }
}

