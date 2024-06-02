package com.racingcar;

public class CarPosition {

    private final Name name;
    private final Position position;

    public CarPosition(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }
}
