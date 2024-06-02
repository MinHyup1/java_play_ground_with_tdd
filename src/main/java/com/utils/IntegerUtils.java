package com.utils;

import java.util.Random;

public class IntegerUtils {
    private static final int MAX_BOUNDARY = 10;

    public static Integer getRandomSingleDigit() {
        return new Random().nextInt(MAX_BOUNDARY);
    }
}
