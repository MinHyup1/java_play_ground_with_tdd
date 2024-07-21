package com.coordinate.figure.carculator;

import com.coordinate.Points;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class CoordinateCalculator {

    public double calculate(final Points points) {

        switch (points.size()) {
            case 2 -> {
                return calculateLine(points);
            }
            case 3 -> {
                return calculateTriangle(points);
            }
            case 4 -> {
                return calculateRectangle(points);
            }
            default -> throw new RuntimeException("Invalid point size: " + points.size() + ". Point size must be 2, 3, or 4.");
        }
    }

    private double calculateLine(final Points points) {
        LinkedList<Double> lineDistances = points.getAllLineDistance().stream()
                .sorted().collect(Collectors.toCollection(LinkedList::new));
        return lineDistances.stream().findFirst().orElseThrow(() -> new RuntimeException("do not have line"));
    }

    private double calculateTriangle(final Points points) {
        final LinkedList<Double> lineDistances = points.getAllLineDistance().stream()
                .sorted().collect(Collectors.toCollection(LinkedList::new));

        //이등변 삼각형일 경우 짧은변을 리스트에 더해준다
        if(lineDistances.size() == 2) lineDistances.add(2, lineDistances.get(0));

        if (lineDistances.size() != 3) {
            throw new IllegalArgumentException("Three sides are required to form a triangle");
        }

        double a = lineDistances.get(0);
        double b = lineDistances.get(1);
        double c = lineDistances.get(2);

        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    private double calculateRectangle(final Points points) {
        final LinkedList<Double> lineDistances = points.getAllLineDistance().stream()
                .sorted().collect(Collectors.toCollection(LinkedList::new));

        if(lineDistances.size() > 3) throw new RuntimeException("not coordinate Rectangle");

        if(lineDistances.size() == 2) return lineDistances.get(0) * lineDistances.get(0);

        return lineDistances.get(0) * lineDistances.get(1);
    }
}
