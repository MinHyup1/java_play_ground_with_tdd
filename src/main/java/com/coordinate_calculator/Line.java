package com.coordinate_calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Line implements Figure {

    private final List<Coordinate> coordinates;
    private final Double calculateResult;

    public Line(List<Coordinate> coordinates, Double calculateResult) {
        this.coordinates = coordinates;
        this.calculateResult = calculateResult;
    }

    @Override
    public String getCalculateResult(int decimalPlaces) {
        BigDecimal bigDecimal = BigDecimal.valueOf(calculateResult);
        bigDecimal = bigDecimal.setScale(decimalPlaces, RoundingMode.HALF_UP);
        return String.format("두 점 사이의 거리는 %s", bigDecimal.toString());
    }
}
