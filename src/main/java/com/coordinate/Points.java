package com.coordinate;

import java.util.*;

public class Points {
    List<Point> Points = new ArrayList<>();

    public Points(String pointString) {
        String[] pointArray = pointString.split("-");
        for (int i = 0; i < pointArray.length; i++) {
            this.Points.add(new Point(pointArray[i].replaceAll("[()]", "")));
        }
    }

    public int size() {
        return Points.size();
    }
    public Set<Double> getAllLineDistance() {
        Set<Double> allLineDistance = new HashSet<>();
        for (int i = 0; i < this.Points.size(); i++) {
            for (int j = i + 1; j < this.Points.size(); j++) {
                allLineDistance.add(getLineDistance(Points.get(i).getX(), Points.get(j).getX(), Points.get(i).getY(), Points.get(j).getY()));
            }
        }
        return allLineDistance;
    }

    private double getLineDistance(double x1, double x2,double y1,double y2 ) {
        return Math.sqrt(Math.pow(x1- x2, 2) + Math.pow(y1 - y2, 2));
    }
}
