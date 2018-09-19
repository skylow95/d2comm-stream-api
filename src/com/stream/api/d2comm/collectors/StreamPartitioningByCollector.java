package com.stream.api.d2comm.collectors;

import com.stream.api.d2comm.domain.Phone;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPartitioningByCollector {

    public static void main(String[] args) {
        List<Phone> phones = Arrays.asList(Stream.of(new Phone("iPhone 8", 54000),
                new Phone("Nokia 9", 45000),
                new Phone("Samsung Galaxy S9", 40000),
                new Phone("LG G6", 32000)).toArray(Phone[]::new));

        Map<Boolean, List<Phone>> phonesByPrice = phones
                .stream()
                .collect(Collectors.partitioningBy(
                        p -> p.getPrice() % 2 == 0, // умова по якій групуються значення
                        Collectors.toCollection(LinkedList::new) // тип колекції
                        ));

        phonesByPrice.forEach((price, phone) -> System.out.format("price %s: %s\n", price, phone.toString()));
    }
}
