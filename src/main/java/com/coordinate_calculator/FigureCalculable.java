package com.coordinate_calculator;

public interface FigureCalculable {

    /**
     * FigureCalculable 구현체인 도형별 계산기가 주입받은 좌표 개수에 따라 직선 거리 또는 넓이를 계산하여 응답한다.
     * @return 계산 결과를 담은 도형 정보
     */
    Figure calculate();
}
