package com.racingcar;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CarPositionTest {

    @Test
    void CarPosition은_자동차_이름_래퍼_클래스와_위치_래퍼_클래스를_주입받아_생성된다() {
        CarPosition carPosition = new CarPosition(new Name("자동차A"), new Position(0));
        assertThat(carPosition).isNotNull();
    }

    @Test
    void CarPosition은_getter_호출시_원시값을_응답한다() {
        CarPosition carPosition = new CarPosition(new Name("자동차A"), new Position(0));
        String name = carPosition.getName();
        int position = carPosition.getPosition();

        assertThat(name).isEqualTo("자동차A");
        assertThat(position).isEqualTo(0);
    }
}
