package com.racingcar;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CarTest {

    @DisplayName("자동차는")
    @Nested
    class CarClass {

        @DisplayName("도착 지점에 도착하면 isMaxPoint가 true를 리턴한다.")
        @Test
        void car_moves_when_getting_number_over_4() {
            Car car = new Car("1번");
            int movableNumber = 9;
            car.move(movableNumber);
            car.move(movableNumber);
            car.move(movableNumber);
            car.move(movableNumber);
            car.move(movableNumber);

            assertThat(car.isMaxPoint()).isTrue();
        }

    }

}
