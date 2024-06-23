package com.coordinate.figure.carculator;

import com.coordinate.CoordinateCalculator;
import com.coordinate.Points;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class TriangleCalculator implements CoordinateCalculator {
    @Override
    public double calculate(String pointsString) {
        Points points = new Points(pointsString);
        if(points.size() != 3) throw new RuntimeException("not coordinate triangle");

        LinkedList<Double> lineDistances = points.getAllLineDistance().stream()
                .sorted().collect(Collectors.toCollection(LinkedList::new));

        if(lineDistances.size() > 2) throw new RuntimeException("not coordinate triangle");
        return calculateArea(lineDistances);
    }

    private double calculateArea(LinkedList<Double> lineDistances) {

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
}
