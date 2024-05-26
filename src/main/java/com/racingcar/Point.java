package com.racingcar;

public class Point {

    private static final int FULL_SCORE = 5;
    private int point;

    public void add(int randomNumber) {
        if (isFullScore()) {
            throw new IllegalStateException("이미 골인 지점에 도착한 자동차가 존재합니다. 게임을 다시 시작해주세요.");
        }

        MovableNumber movableNumber = new MovableNumber(randomNumber);
        if (movableNumber.isMovable()) {
            point++;
        }
    }

    public boolean isFullScore() {
        return point >= FULL_SCORE;
    }

    public int getPoint() {
        return point;
    }
}
