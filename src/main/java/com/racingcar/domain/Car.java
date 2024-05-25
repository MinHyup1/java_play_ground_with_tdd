package com.racingcar.domain;

import java.util.Objects;
import java.util.Random;

public class Car {
    private final String carName;
    private int location;

    public Car(String carName) {
        this.carName = carName;
    }

    public int getLocation() {
        return this.location;
    }

    public void moveForward() {
        this.location += create4to9RandomNumber();
    }

    private int create4to9RandomNumber() {
        Random random = new Random();
        return random.nextInt(6) + 4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}
