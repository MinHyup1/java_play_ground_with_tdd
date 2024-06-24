package com.coordinate.figure.carculator;

import com.coordinate.CoordinateCalculator;
import com.coordinate.Points;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class TriangleCalculator implements CoordinateCalculator {
    @Override
    public double calculate(String pointsString) {
        /* jh.
        인터페이스를 구현하고 있지만 인자로 전달받은 좌표의 개수에 따라 동적으로 계산되지 않고,
        미리 만들어둔 삼각형 좌표 계산기의 메서드에 이에 적합한 좌표를 전달해야 하다보니
        각 도형별 계산기의 calculate()에 static이 붙진 않았지만 유틸 클래스 같은 느낌을 받았습니다.
         */
        Points points = new Points(pointsString);
        if(points.size() != 3) throw new RuntimeException("not coordinate triangle");

        LinkedList<Double> lineDistances = points.getAllLineDistance().stream()
                .sorted().collect(Collectors.toCollection(LinkedList::new));

        if(lineDistances.size() > 2) throw new RuntimeException("not coordinate triangle");
        return calculateArea(lineDistances);
    }

    private double calculateArea(LinkedList<Double> lineDistances) {

        //이등변 삼각형일 경우 짧은변을 리스트에 더해준다
        if(lineDistances.size() == 2) lineDistances.add(2, lineDistances.get(0));

        if (lineDistances.size() != 3) {
            throw new IllegalArgumentException("Three sides are required to form a triangle");
        }

        double a = lineDistances.get(0);
        double b = lineDistances.get(1);
        double c = lineDistances.get(2);

        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}
