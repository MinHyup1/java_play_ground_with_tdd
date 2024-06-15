package com.car;

import com.car.Car;

public class K5 extends Car {
    private static final String K5 = "K5";
    private static final double DISTANCE_PER_LITER = 13;


    private final double tripDistance;
    public K5(int distance) {
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
        return K5;
    }
}
