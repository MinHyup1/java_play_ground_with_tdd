package com.coordinate_calculator;

import java.util.LinkedList;
import java.util.List;

public class TriangleCalculator implements FigureCalculable {

    private final List<Coordinate> coordinates;

    public TriangleCalculator(LinkedList<Coordinate> coordinates) {
        if (coordinates == null || coordinates.size() < 3) {
            throw new IllegalArgumentException();
        }
        this.coordinates = coordinates;
    }

    @Override
    public Figure calculate() {
        Double area = null;//todo 계산
        return new Triangle(coordinates, area);
    }
}
