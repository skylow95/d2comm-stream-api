package com.stream.api.d2comm.map;

import com.stream.api.d2comm.domain.Phone;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamFlatMap {

    public static void main(String[] args) {
        simpleFlatMap();
        flatMapByListStream();
    }

    private static void simpleFlatMap() {
        Stream.of(2, 3, 0, 1, 3)
                .flatMapToInt(x -> IntStream.range(0, x))
                .forEach(System.out::println);
    }

    private static void flatMapByListStream() {
        System.out.println("###Next FLAT MAP");
        List<Phone> phones = Arrays.asList(Stream.of(new Phone("iPhone 8", 54000),
                new Phone("Nokia 9", 45000),
                new Phone("Samsung Galaxy S9", 40000),
                new Phone("LG G6", 32000)).toArray(Phone[]::new));

        List<List<Phone>> phonesInList = Collections.singletonList(phones);

        List<String> result = phonesInList.stream()
                .flatMap(List::stream)
                .map(Phone::getName)
                .collect(Collectors.toList());

        result.forEach(System.out::println);
    }

}
