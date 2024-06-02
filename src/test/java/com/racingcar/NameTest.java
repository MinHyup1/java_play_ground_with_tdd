package com.racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {
    @DisplayName("자동차 이름 클래스는 null, 공백 문자열, blank, 5글자를 초과 문자열을 입력받으면 IllegalArgumentException을 리턴한다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "123456"})
    void test(String invalidName) {
        assertThatThrownBy(() -> new Name(invalidName))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("유효하지 않은 이름입니다. 1~5글자의 문자열 입력.");
    }
}
