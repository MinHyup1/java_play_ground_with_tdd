package com.racingcar;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @DisplayName("Cars는")
    @Nested
    class CarsClass {

        @DisplayName("매 턴 자동차의 위치를 리턴한다.")
        @Test
        void constructor_test() {
            Cars cars = new Cars(List.of("자동차A", "자동차B", "자동차C"));
            cars.move();
            Points points = cars.getCurrentPoints();
        }
    }
}
