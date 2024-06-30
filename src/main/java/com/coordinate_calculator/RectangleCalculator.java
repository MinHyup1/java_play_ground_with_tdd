package com.coordinate_calculator;

import java.util.LinkedList;
import java.util.List;

public class RectangleCalculator implements FigureCalculable {

    private final List<Coordinate> coordinates;

    public RectangleCalculator(LinkedList<Coordinate> coordinates) {
        if (coordinates == null || coordinates.size() < 4) {
            throw new IllegalArgumentException();
        }
        this.coordinates = coordinates;
    }

    @Override
    public Figure calculate() {
        return null;
    }
}
