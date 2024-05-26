package com.racingcar;

import java.util.ArrayList;
import java.util.List;

public class Points {

    private List<PointWithName> pointWithNames;

    public Points() {
        this.pointWithNames = new ArrayList<>();
    }

    public void add(CarName carName, Point point) {
        PointWithName pointWithName = new PointWithName(carName, point);
        this.pointWithNames.add(pointWithName);
    }



    private static class PointWithName {
        private final CarName carName;
        private final Point point;

        public PointWithName(CarName carName, Point point) {
            this.carName = carName;
            this.point = point;
        }
    }
}
