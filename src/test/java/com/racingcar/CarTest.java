package com.racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @Test
    void 자동차는_이름과_위치를_입력받아_생성된다() {
        Car car = new Car("자동차1", 0);
        assertThat(car).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 자동차는_랜덤값이_0이상_3이하일_때_이동하지_않는다(int notMoveNumber) {
        Car car = new Car("자동차1", 0);
        car.move(notMoveNumber);
        Position currentPosition = car.getPosition();

        Position position = new Position(1);

        assertThat(currentPosition).isNotEqualTo(position);
    }
}
