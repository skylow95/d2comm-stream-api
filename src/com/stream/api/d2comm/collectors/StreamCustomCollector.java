package com.stream.api.d2comm.collectors;

import com.stream.api.d2comm.domain.Phone;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class StreamCustomCollector {

    public static void main(String[] args) {
        customLightWeightCollector();
        customCollector();
    }

    private static void customLightWeightCollector() {
        Stream<String> phonesName = Stream.of("iPhone 8", "HTC U12", "Huawei Nexus 6P",
                "Samsung Galaxy S9", "LG G6", "Xiaomi MI6", "ASUS Zenfone 2",
                "Sony Xperia Z5", "Meizu Pro 6", "Lenovo S850");

        List<String> filteredPhones = phonesName.filter(phone -> phone.length() < 12)
                .collect(
                        ArrayList::new, // створюєм ArrayList
                        ArrayList::add, // додаєм елемент в список
                        ArrayList::addAll); // додаємо список в інший список

        filteredPhones.forEach(System.out::println);
    }

    private static void customCollector() {
        List<Phone> phones = Arrays.asList(Stream.of(new Phone("iPhone 8", 54000),
                new Phone("Nokia 9", 45000),
                new Phone("Samsung Galaxy S9", 40000),
                new Phone("LG G6", 32000)).toArray(Phone[]::new));

        Collector<Phone, StringJoiner, String> personNameCollector =
                Collector.of(
                        () -> new StringJoiner(" | "),          // supplier
                        (j, p) -> j.add(p.getName().toUpperCase()),  // accumulator
                        StringJoiner::merge,               // combiner
                        StringJoiner::toString);                // finisher

        String names = phones
                .stream()
                .collect(personNameCollector);

        System.out.println(names);
    }
}
