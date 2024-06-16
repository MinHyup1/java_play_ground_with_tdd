package com.coordinate.figure.carculator;

import com.coordinate.CoordinateCalculator;
import com.coordinate.Points;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class RectangleCalculator implements CoordinateCalculator {
    @Override
    public double calculate(String coordinatesToString) {
        Points coordinates = new Points(coordinatesToString);
        if(coordinates.size() != 4) throw new RuntimeException("not coordinate Rectangle");

        LinkedList<Double> lineDistances = coordinates.getAllLineDistance().stream().sorted().collect(Collectors.toCollection(LinkedList::new));
        return calculateArea(lineDistances);
    }

    private double calculateArea(LinkedList<Double> lineDistances) {
        if(lineDistances.size() == 2) return lineDistances.get(0) * lineDistances.get(0);
        return lineDistances.get(0) * lineDistances.get(1);
    }
}
