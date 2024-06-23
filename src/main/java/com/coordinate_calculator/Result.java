package com.coordinate_calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Result {

    private final Figure figure;
    private final double value;

    public Result(Figure figure, double value) {
        Objects.requireNonNull(figure);
        this.figure = figure;
        this.value = value;
    }

    public String print(int decimalPlaces) {
        BigDecimal bigDecimal = BigDecimal.valueOf(value);
        bigDecimal = bigDecimal.setScale(decimalPlaces, RoundingMode.HALF_UP);
        return String.format("%s의 %s는 %s", figure.name, figure.unit, bigDecimal.toString());
    }
}
