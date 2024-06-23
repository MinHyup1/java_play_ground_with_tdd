package com.coordinate_calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Coordinates {

    private final List<Coordinate> coordinates;

    public Coordinates(final List<Coordinate> coordinates) {
        Objects.requireNonNull(coordinates);
        this.coordinates = new ArrayList<>(coordinates);
    }

    /**
     * 좌표 개수별 계산 로직 수행
     * @return
     */
    public Result calculate() {
        if (coordinates.size() == 2) {
            Coordinate one = coordinates.get(0);
            Coordinate theOther = coordinates.get(1);
            Double distance = one.calculateDistance(theOther);
            return new Result(Figure.LINE, distance);
        }

        Double height = getHeight();
        Double width = getWidth();
        return new Result(Figure.RECTANGLE, height * width);
    }


    private Double getHeight() {
        Coordinate left = coordinates.stream()
            .reduce(coordinates.get(0), (co1, co2) -> co1.findLeft(co2));

        List<Coordinate> oneLeftFiltered = coordinates.stream()
            .filter(coordinate -> !coordinate.equals(left))
            .collect(Collectors.toList());

        Coordinate anotherLeft = oneLeftFiltered.stream()
            .reduce(oneLeftFiltered.get(0), (co1, co2) -> co1.findLeft(co2));

        return left.calculateDistance(anotherLeft);
    }

    private Double getWidth() {
        Coordinate upper = coordinates.stream()
            .reduce(coordinates.get(0), (co1, co2) -> co1.findUpper(co2));

        List<Coordinate> oneUpperFiltered = coordinates.stream()
            .filter(coordinate -> !coordinate.equals(upper))
            .collect(Collectors.toList());

        Coordinate anotherUpper = oneUpperFiltered.stream()
            .reduce(oneUpperFiltered.get(0), (co1, co2) -> co1.findUpper(co2));

        return upper.calculateDistance(anotherUpper);
    }
}
