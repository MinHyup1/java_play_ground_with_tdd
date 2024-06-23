package com.coordinate_calculator;

public enum Figure {

    LINE("직선", "길이"),
    RECTANGLE("사각형", "면적"),
    TRIANGLE("삼각형", "면적");

    String name;
    String unit;

    Figure(String name, String unit) {
        this.name = name;
        this.unit = unit;
    }
}
