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
    //todo Result가 아니라 Figure를 리턴했으면 더 좋았을 것같다.
    // 그러면 괜히 enum 만들어서 구현이 Coordinates로 새어나오게 하지도 않았을 거고,
    // 어디선가 enum 가지고 분기문 태우는 코드를 작성할 여지도 줄일 수 있었을 듯.
    public Result calculate() {
        if (coordinates.size() == 2) {
            Coordinate one = coordinates.get(0);
            Coordinate theOther = coordinates.get(1);
            Double distance = one.calculateDistance(theOther);
            return new Result(Figure.LINE, distance);
        }

        if (coordinates.size() == 4) {
            Double height = getHeight();
            Double width = getWidth();
            return new Result(Figure.RECTANGLE, height * width);
        }

        Double a = coordinates.get(0).calculateDistance(coordinates.get(1));
        Double b = coordinates.get(0).calculateDistance(coordinates.get(2));
        Double c = coordinates.get(1).calculateDistance(coordinates.get(2));

        double area = Math.sqrt((a + b + c) * (-a + b + c) * (a - b + c) * (a + b - c)) / 4;

        return new Result(Figure.TRIANGLE, area);
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
