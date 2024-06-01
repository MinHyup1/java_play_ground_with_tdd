package com.racingcar.domain;

import java.util.Objects;
import java.util.Random;

public class Car {
    private final String carName;
    private Location location;

    public Car(String carName) {
        this.carName = carName;
        this.location = new Location();
    }

    public Car(String carName, Location location) {
        this.carName = carName;
        this.location = location;
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(9);
    }

    //for test
    public void moveOrStopByRandomNumber(int number) {
        if(number >= 4) {
            this.location.advanceOneStep();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return Objects.equals(carName, car.carName) && Objects.equals(location, car.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, location);
    }
}
