package com.racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 자동차는_이름과_위치를_입력받아_생성된다() {
        Car car = new Car("자동차1", 0);
        assertThat(car).isNotNull();
    }
}
