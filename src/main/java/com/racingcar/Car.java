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
        if (randomNumber > 9) {
            throw new IllegalArgumentException("유효하지 않은 범위의 숫자입니다. 0이상 9이하의 값을 입력해주세요.");
        }

        if (randomNumber >= MOVABLE_NUMBER_LOWER_LIMIT) {
            position = position.next();
        }
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name.getName();
    }
}
