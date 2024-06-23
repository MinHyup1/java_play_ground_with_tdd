package com.coordinate_calculator;

import java.util.Objects;

public class Point {

    private final int value;

    public Point(int value) {
        if (value < 0 || 24 < value) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return value == point.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
