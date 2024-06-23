package com.coordinate_calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Result 단위테스트")
public class ResultTest {

    @DisplayName("Result는 도형, 값을 입력받아 생성된다.")
    @Test
    void test() {
        Result result = new Result(Figure.RECTANGLE, 16);
        assertThat(result).isNotNull();
    }
}
