package com.coordinate_calculator;

public class Point {

    private final int value;

    public Point(int value) {
        if (value < 0 || 24 < value) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }
}
