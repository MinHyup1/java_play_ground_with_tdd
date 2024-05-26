package com.racingcar;

import java.util.Objects;

public class Point {

    private static final int FULL_SCORE = 5;
    private int point;

    public void add(MovableNumber movableNumber) {
        Objects.requireNonNull(movableNumber);
        if (isFullScore()) {
            throw new IllegalStateException("이미 골인 지점에 도착한 자동차가 존재합니다. 게임을 다시 시작해주세요.");
        }

        if (movableNumber.isMovable()) {
            point++;
        }
    }

    public boolean isFullScore() {
        return point >= FULL_SCORE;
    }
}
