package com.coordinate.figure.carculator;

import com.coordinate.CoordinateCalculator;
import com.coordinate.Points;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class LineCalculator implements CoordinateCalculator {
    @Override
    public double calculate(String coordinatesToString) {
        Points points = new Points(coordinatesToString);
        if(points.size() != 2) throw new RuntimeException("not coordinate line");

        LinkedList<Double> lineDistances = points.getAllLineDistance().stream()
                .sorted().collect(Collectors.toCollection(LinkedList::new));

        return lineDistances.stream().findFirst().orElseThrow(() -> new RuntimeException("do not have line"));
    }
}
