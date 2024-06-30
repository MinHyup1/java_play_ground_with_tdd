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
        Coordinate one = coordinates.get(0);
        Coordinate two = coordinates.get(1);
        Coordinate three = coordinates.get(2);

        // Line todo 현재 Line은 Figure를 구현한 출력담당 클래스이지만 도형 계산에 도움을 줄 Line 객체가 있으면  좋을 것 같다.
        Double a = one.calculateDistance(two);
        Double b = two.calculateDistance(three);
        Double c = three.calculateDistance(one);

        double area = Math.sqrt((a + b + c) * (- a + b + c) * (a - b + c) * (a + b - c)) / 4;
        return new Triangle(coordinates, area);
    }
}
