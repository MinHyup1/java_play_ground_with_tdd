package com.coordinate_calculator;

import java.util.Objects;

public class Point {

    // [review] 포인트까지 객체화 하는것이 유효성검증하는데 더 좋아보이고 객체지향적인것 같습니다. 저도 주임님 하신것 처럼 해야겠네요
    private final int value;

    public Point(int value) {
        if (value < 0 || 24 < value) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return value == point.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
