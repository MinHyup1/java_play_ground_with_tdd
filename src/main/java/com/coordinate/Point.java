package com.coordinate;

public class Point {
    private double x;
    private double y;

    public Point(String coordinate) {
        String[] points = coordinate.split(",");
        this.x = Double.parseDouble(points[0]);
        this.y = Double.parseDouble(points[1]);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
