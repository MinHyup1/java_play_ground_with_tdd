package com.racingcar;

import java.util.function.Supplier;

public class MovableNumber {

    private final int number;
    private static final int MINIMUM_MOVABLE_VALUE = 4;

    public MovableNumber(int number) {
        if (number < 0 || number > 9) {
            throw new IllegalArgumentException("유효하지 않은 값. 0~9값 입력");
        }
        this.number = number;
    }

    public boolean isMovable() {
        return MINIMUM_MOVABLE_VALUE <= this.number;
    }
}
