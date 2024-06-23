package com.coordinate_calculator;

import java.util.Objects;

public class Coordinate {

    private final Point x;
    private final Point y;

    public Coordinate(Point x, Point y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 좌표간 직선 거리를 계산한다.
     * @param theOther
     * @return
     */
    public Double calculateDistance(Coordinate theOther) {
        Objects.requireNonNull(theOther);
        if (this.equals(theOther)) {
            throw new IllegalArgumentException();
        }

        return Math.sqrt(Math.pow(Math.abs(this.getPointX() - theOther.getPointX()), 2)
                + Math.pow(Math.abs(this.getPointY() - theOther.getPointY()), 2));
    }

    private int getPointX() {
        return this.x.getValue();
    }

    private int getPointY() {
        return this.y.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Coordinate that = (Coordinate) o;
        return Objects.equals(x, that.x) && Objects.equals(y, that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
