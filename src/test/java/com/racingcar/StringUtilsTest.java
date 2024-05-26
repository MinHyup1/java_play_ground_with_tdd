package com.racingcar;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    @DisplayName("StringUtils는")
    @Nested
    class StringUtilsClass {

        @DisplayName("입력받은 구분자를 기준으로 문자열을 분리하여 List로 리턴한다.")
        @Test
        void separate_test() {
            List<String> carNames = StringUtils.separate("자동차A,자동차B,자동차C", ",");

            Assertions.assertThat(carNames).contains("자동차A", "자동차B", "자동차C");
        }

        @DisplayName("문자열에 null을 입력하면 NPE를 리턴한다.")
        @Test
        void throw_NPE_when_getting_null_sentence() {
            Assertions.assertThatThrownBy(() -> StringUtils.separate(null, ","))
                    .isInstanceOf(NullPointerException.class);
        }

        @DisplayName("구분자에 null을 입력하면 NPE를 리턴한다.")
        @Test
        void throw_NPE_when_getting_null_separator() {
            Assertions.assertThatThrownBy(() -> StringUtils.separate("sentence", null))
                .isInstanceOf(NullPointerException.class);
        }
    }
}
