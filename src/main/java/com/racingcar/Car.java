package com.racingcar;

public class Car {

    private final CarName name;
    private final Point point;

    public Car(String name) {
        this.name = new CarName(name);
        this.point = new Point();
    }

    public void move(int randomNumber) {
        MovableNumber movableNumber = new MovableNumber(randomNumber);
        point.add(movableNumber);
    }

    public boolean isMaxPoint() {
        return point.isFullScore();
    }
}
