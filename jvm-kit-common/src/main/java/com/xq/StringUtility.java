package com.xq;

import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class StringUtility {
    public static String generateRandomString(int length) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static BiFunction<Integer, String, String> generateRandomStringPrefix = (length, prefix) -> {
        if (prefix == null || prefix.isEmpty()) {
            return generateRandomString(length);
        }
        return prefix + generateRandomString(length);
    };

    public static Supplier<String> fnGenerateRandomStringPrefix(Integer length, String prefix) {
        return () -> generateRandomStringPrefix.apply(length, prefix);
    }
}
