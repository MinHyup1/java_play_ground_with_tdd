package com.racingcar;

public class Car {

    private final CarName name;
    private final Point point;

    public Car(String name) {
        this.name = new CarName(name);
        this.point = new Point();
    }

    public void move(int randomNumber) {
        point.add(randomNumber);
    }

    public boolean isMaxPoint() {
        return point.isFullScore();
    }

    public CarName getName() {
        return name;
    }

    public Point getPoint() {
        return point;
    }
}
