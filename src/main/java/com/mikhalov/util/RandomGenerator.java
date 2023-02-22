package com.mikhalov.util;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class RandomGenerator {
    private static final Random RANDOM = new Random();

    public static String getString() {
        int length = RANDOM.nextInt(5, 11);
        return RandomStringUtils.random(length, true, false);
    }

    public static int getAge() {
        return RANDOM.nextInt(16, 41);
    }

    public static int getRandomGrade() {
        return RANDOM.nextInt(50, 101);
    }

}
