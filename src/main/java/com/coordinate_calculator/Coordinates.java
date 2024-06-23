package com.coordinate_calculator;

import java.util.ArrayList;
import java.util.List;

public class Coordinates {

    private final List<Coordinate> coordinates;

    public Coordinates(final List<Coordinate> coordinates) {
        this.coordinates = new ArrayList<>(coordinates);
    }
}
