package com.coordinate_calculator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class FigureCalculatorFactory {

    public static FigureCalculable create(Collection<Coordinate> calculates) {
        Objects.requireNonNull(calculates, "계산기 생성 실패. 좌표를 입력해주세요");

        FigureCalculable calculator = switch (calculates.size()) {
            case 2 -> new LineCalculator(new ArrayList<>(calculates));
            default -> throw new IllegalArgumentException("???");
        };

        return calculator;
    }
}
