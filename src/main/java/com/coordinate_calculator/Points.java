package com.coordinate_calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Points {

    private final List<Point> points;

    public Points(int ...values) {
        Objects.requireNonNull(values);

        if (values.length % 2 == 1) {
            throw new IllegalArgumentException("좌표가 잘못 입력되었습니다.");
        }

        if (values.length == 8) {
            validateRectangle(values);

            this.points = Arrays.stream(values)
            .mapToObj(Point::new)
            .collect(Collectors.toList());
            return;
        }

        //todo 직선, 삼각형인 경우
        this.points = List.of();
    }

    private static void validateRectangle(int[] values) {
        long uniqueValueCnt = Arrays.stream(values)
            .boxed()
            .collect(Collectors.toSet())
            .stream()
            .count();

        if (uniqueValueCnt != 2) {
            throw new IllegalArgumentException("직사각형 면적만 계산할 수 있습니다.");
        }
    }
}
