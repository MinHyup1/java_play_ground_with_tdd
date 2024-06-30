package com.coordinate_calculator;

public interface Figure {

    /**
     * FigureCalculable 구현체가 계산한 도형별 계산 결과를 응답합니다.
     * @param decimalPlaces 출력할 소수점 자리수
     * @return 도형별 계산 결과
     */
    Double getCalculateResult(int decimalPlaces);
}
