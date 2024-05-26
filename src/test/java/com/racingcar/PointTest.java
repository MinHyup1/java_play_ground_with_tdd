package com.racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointTest {

    @DisplayName("Point는 5점이 만점이다.")
    @Test
    void full_score_point_test() {
        Point point = new Point();
        MovableNumber movableNumber = new MovableNumber(4);
        point.add(movableNumber);
        point.add(movableNumber);
        point.add(movableNumber);
        point.add(movableNumber);
        point.add(movableNumber);

        Assertions.assertThat(point.isFullScore()).isTrue();
    }
}
