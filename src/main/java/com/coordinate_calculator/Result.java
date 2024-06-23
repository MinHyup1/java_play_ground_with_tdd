package com.coordinate_calculator;

import java.util.Objects;

public class Result {

    private final Figure figure;
    private final double value;

    public Result(Figure figure, double value) {
        Objects.requireNonNull(figure);
        this.figure = figure;
        this.value = value;
    }
}
