package com.racingcar;

import java.util.Random;

public class RandomNumberUtils {

    public static int generate() {
        Random random = new Random();
        return random.nextInt(9);
    }
}
