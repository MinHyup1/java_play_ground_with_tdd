package com.racingcar;

import com.racingcar.validation.Validation;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;

public class ValidationTest {

    @Test
    void 자동차의_이름은_5자를_초과할_수_없다 () {
        String carName = "JAMES";
        Validation validation = new Validation();
        // When
        Throwable thrown = catchThrowable(() -> {
            validation.carNameValidation(carName);
        });

        // Then
        assertThat(thrown).isNull();
    }

    @Test
    void 자동차의_이름은_5자를_초과하면_예외가_발생해야_한다 () {
        String carName = "James Francis Cameron";
        Validation validation = new Validation();
        // When
        Throwable thrown = catchThrowable(() -> {
            validation.carNameValidation(carName);
        });

        // Then
        assertThat(thrown).isInstanceOf(RuntimeException.class);
    }

//    @Test
//    void 자동차의_이름은_중복될_수_없다 () {
//        String carName = "JAMES";
//        Validation validation = new Validation();
//        assertThat(validation.carNameValidation(carName)).isTrue();
//    }
}
