package com.racingcar;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class PointTest {

    @DisplayName("Point는")
    @Nested
    class PointClass {

        @DisplayName("MovableNumber의 isMovable()이 false를 리턴하면 포인트를 증가시키지 않는다.")
        @Test
        void not_full_score_point_test() {
            Point point = new Point();
            MovableNumber notMovableNumber = new MovableNumber(3);

            point.add(notMovableNumber);
            point.add(notMovableNumber);
            point.add(notMovableNumber);
            point.add(notMovableNumber);
            point.add(notMovableNumber);

            assertThat(point.isFullScore()).isFalse();
        }

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

            assertThat(point.isFullScore()).isTrue();
        }

        @DisplayName("add()에 null을 입력하면 NPE를 발생시킨다.")
        @Test
        void throw_NPE_when_getting_null_argument() {
            Point point = new Point();

            assertThatThrownBy(() -> point.add(null))
                .isInstanceOf(NullPointerException.class);
        }

        @DisplayName("점수가 만점일 때 add를 호출하면 IllegalStateException을 발생시킨다.")
        @Test
        void throw_IllegalStateException_when_calling_add_method_with_full_score() {
            Point point = new Point();
            MovableNumber movableNumber = new MovableNumber(4);
            point.add(movableNumber);
            point.add(movableNumber);
            point.add(movableNumber);
            point.add(movableNumber);
            point.add(movableNumber);

            assertThatThrownBy(() -> point.add(movableNumber))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("이미 골인 지점에 도착한 자동차가 존재합니다. 게임을 다시 시작해주세요.");
        }
    }
}
