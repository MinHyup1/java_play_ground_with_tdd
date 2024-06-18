package com.coordinate_calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Point 단위테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PointTest {

    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -1, 25, Integer.MAX_VALUE})
    void x_y_좌표는_각각_0_미만_24_초과시_예외가_발생한다(int value) {
        assertThatThrownBy(() -> new Point(value))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 24})
    void x_y_좌표는_각각_0부터_24_이하의_값을_입력하여_생성한다(int value) {
        Point point = new Point(value);
        assertThat(point).isNotNull();
    }
}
