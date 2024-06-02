package com.racingcar;

public class Car {

    private static final int MOVABLE_NUMBER_LOWER_LIMIT = 4;
    private final Name name;
    private Position position;

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVABLE_NUMBER_LOWER_LIMIT) {
            position = position.next();
        }
    }

    public Position getPosition() {
        return position;
    }
}
