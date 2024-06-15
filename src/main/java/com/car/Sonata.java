package com.car;

import com.car.Car;

public class Sonata extends Car {
    private static final String SONATA = "Sonata";
    private static final double DISTANCE_PER_LITER = 10;


    private final double tripDistance;
    public Sonata(int distance) {
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
        return SONATA;
    }
}
