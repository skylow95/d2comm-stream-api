package com.stream.api.d2comm;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamSimpleToMap {

    public static void main(String[] args) {
        Stream<Phone> phoneStream = Stream.of(new Phone("iPhone 8", 54000),
                new Phone("Nokia 9", 45000),
                new Phone("Samsung Galaxy S9", 40000),
                new Phone("LG G6", 32000));


        Map<String, Integer> phones = phoneStream
                .collect(Collectors.toMap(Phone::getName, Phone::getPrice));

        phones.forEach((key, value) -> System.out.println(key + " " + value));
    }
}


class Phone {

    private String name;
    private int price;

    Phone(String name, int price) {
        this.name = name;
        this.price = price;
    }

    String getName() {
        return name;
    }

    int getPrice() {
        return price;
    }
}
