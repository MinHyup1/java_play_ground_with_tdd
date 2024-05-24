package com.racingcar;

import com.racingcar.validation.Validation;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationTest {

    @Test
    void 자동차의_이름은_5자를_초과할_수_없다 () {
        String carName = "JAMES";
        Validation validation = new Validation();
        assertThat(validation.carNameValidation(carName)).isTrue();
    }
}
