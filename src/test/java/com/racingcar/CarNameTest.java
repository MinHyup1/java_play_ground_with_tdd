package com.racingcar;

import com.racingcar.domain.car.Car;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;

public class CarNameTest {

    @Test
    void 자동차의_이름은_5자를_초과할_수_없다 () {
        // When
        Throwable thrown = catchThrowable(() -> {
            new Car("JAMSE");
        });

        // Then
        assertThat(thrown).isNull();
    }

    @Test
    void 자동차의_이름은_5자를_초과하면_예외가_발생해야_한다 () {
        // When
        Throwable thrown = catchThrowable(() -> {
            new Car("James Francis Cameron");
        });

        // Then
        assertThat(thrown).isInstanceOf(RuntimeException.class);
    }
}
