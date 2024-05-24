package com.racingcar;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("MoveNumber 단위테스트")
public class MoveForwardNumberTest {

    @DisplayName("0 미만, 9 초과 값을 입력하면 IllegalArgumentException을 리턴한다.")
    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -1, 10, Integer.MAX_VALUE})
    void constructor_throw_illegal_args_exception(int invalidNumber) {
        Assertions.assertThatThrownBy(() -> new MoveNumber(invalidNumber));
    }

    @DisplayName("3 이하의 값을 입력 받으면 전진 불가능하다고 판단한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void isMovable_false(int notMovableNumber) {
        MoveNumber moveNumber = new MoveNumber(notMovableNumber);
        assertThat(moveNumber.isMovable()).isFalse();
    }

    @DisplayName("4 이상의 값을 입력 받으면 전진 가능하다고 판단한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void isMovable_true(int movableNumber) {
        MoveNumber moveNumber = new MoveNumber(movableNumber);
        assertThat(moveNumber.isMovable()).isTrue();
    }
}
