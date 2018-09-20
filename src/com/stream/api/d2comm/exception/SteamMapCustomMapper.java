package com.stream.api.d2comm.exception;

import java.net.URLEncoder;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SteamMapCustomMapper {

    public static void main(String[] args) {
        String[] strings = Stream.of("12", "b", "c").toArray(String[]::new);
        String result = encodedAddressUsingWrapper(strings);
        System.out.println(result);
    }

    static String encodedAddressUsingWrapper(String... address) {
        return Arrays.stream(address)
                .map(wrapper(s -> URLEncoder.encode(s, "UTF-8")))
                .collect(Collectors.joining(", "));
    }

    private static <T, R, E extends Exception> Function<T, R> wrapper(FunctionWithException<T, R, E> func) {
        return arg -> {
            try {
                return func.apply(arg);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    @FunctionalInterface
    interface FunctionWithException<T, R, E extends Exception> {

        R apply(T t) throws E;
    }
}
