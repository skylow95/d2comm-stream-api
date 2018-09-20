package com.stream.api.d2comm.collectors;

import com.stream.api.d2comm.domain.Phone;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamGroupingByCollector {

    public static void main(String[] args) {
        collectSimpleGrouping();
        collectGrouping();
    }

    private static void collectSimpleGrouping() {
        List<Phone> phones = Arrays.asList(Stream.of(new Phone("iPhone 8", 54000),
                new Phone("Nokia 9", 45000),
                new Phone("Samsung Galaxy S9", 40000),
                new Phone("LG G6", 32000)).toArray(Phone[]::new));

        Map<Integer, List<Phone>> phonesByPrice = phones
                .stream()
                .collect(Collectors.groupingBy(Phone::getPrice));

        phonesByPrice.forEach((price, phone) -> System.out.format("price %s: %s\n", price, phone));
    }

    private static void collectGrouping() {
        List<Phone> phones = Arrays.asList(Stream.of(new Phone("iPhone 8", 54000),
                new Phone("Nokia 9", 45000),
                new Phone("Samsung Galaxy S9", 40000),
                new Phone("LG G6", 32000)).toArray(Phone[]::new));

        Map<Integer, List<Phone>> phonesByPrice = phones
                .stream()
                .collect(Collectors.groupingBy(
                        Phone::getPrice,
                        Collectors.toCollection(LinkedList::new)
                        ));

    }

}
