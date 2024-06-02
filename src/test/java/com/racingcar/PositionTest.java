package com.racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PositionTest {

    @Test
    void Position은_위치값을_주입받아_생성된다() {
        Position position = new Position(3);
        Assertions.assertThat(position).isNotNull();
    }
}
