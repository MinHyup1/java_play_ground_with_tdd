package com.car;

import com.car.Car;

public class Avante extends Car {
    private static final String AVANTE = "Avante";
    private static final double DISTANCE_PER_LITER = 15;

    private final double tripDistance;
    public Avante(int distance) {
        this.tripDistance = distance;
    }
    @Override
    double getDistancePerLiter() {
        return DISTANCE_PER_LITER;
    }

    @Override
    double getTripDistance() {
        return tripDistance;
    }

    @Override
    String getName() {
        return AVANTE;
    }
}
