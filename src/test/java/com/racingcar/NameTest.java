package com.racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class NameTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "123456"})
    void 자동차_이름은_생성자에_유효하지_않은_이름을_주입받으면_예외를_발생시킨다(String invalidName) {
        assertThatThrownBy(() -> new Name(invalidName))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("유효하지 않은 이름입니다. 1~5글자의 문자열 입력.");
    }
}
