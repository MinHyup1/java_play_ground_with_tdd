package com.racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MoveForwardNumberTest {

    @Test
    void moveNumber_has_a_number_in_the_range_of_0_9() {
        MoveNumber moveNumber = new MoveNumber(3);
        assertThat(moveNumber.isMovable()).isFalse();
    }
}
