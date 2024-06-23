package com.coordinate_calculator;

import java.io.IOException;
import java.util.IllegalFormatException;

public class Main {

    public static void main(String[] args) throws IOException {
        int[] pointValues = new int[]{};
        try {
            pointValues = Input.getCoordinates();
            if (pointValues[0] == 9999) {
                System.out.println("종료합니다");
                return;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("좌표 입력 오류.");
        }

        Points points = new Points(pointValues);
        Coordinates coordinates = points.toCoordinates();
        Result calculationResult = coordinates.calculate();

        Print.result(calculationResult);
    }
}
