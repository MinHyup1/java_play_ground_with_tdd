package com.coordinate_calculator;

public interface Figure {

    /**
     * FigureCalculable을 구현한 계산기의 계산 결과를 사용자가 보기 쉬운 형태로 출력합니다.
     * @param decimalPlaces 출력할 소수점 자리수
     * @return 도형별 계산 결과
     */
    String getCalculateResult(int decimalPlaces);
}
