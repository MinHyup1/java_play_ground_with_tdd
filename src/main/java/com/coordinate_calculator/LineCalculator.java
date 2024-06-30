package com.coordinate_calculator;

import java.util.List;

//todo 좌표의 유효성 검사는 각 계산기 생성자에서 하도록 할까?
public class LineCalculator implements FigureCalculable {

    private final List<Coordinate> coordinates;

    public LineCalculator(List<Coordinate> coordinates) {
        if (coordinates == null || coordinates.size() < 2) {
            throw new IllegalArgumentException();
        }
        this.coordinates = coordinates;
    }
}
