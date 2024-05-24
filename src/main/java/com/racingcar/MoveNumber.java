package com.racingcar;

import java.util.Objects;

public class MoveNumber {

    private final int number;
    private static final int MINIMUM_MOVABLE_VALUE = 4;

    public MoveNumber(int number) {
        Objects.requireNonNull(number);
        if (number < 0 || number > 9) {
            throw new IllegalArgumentException("유효하지 않은 값. 0~9값 입력");
        }
        this.number = number;
    }

    public boolean isMovable() {
        return MINIMUM_MOVABLE_VALUE <= this.number;
    }
}
