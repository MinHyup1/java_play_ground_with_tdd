package com.racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PositionTest {

    @Test
    void Position은_위치값을_주입받아_생성된다() {
        Position position = new Position(3);
        assertThat(position).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -1, 6, Integer.MAX_VALUE})
    void Position_생성시_0미만_6이상의_값을_입력하면_예외가_발생한다(int invalidPosition) {
        assertThatThrownBy(() -> new Position(invalidPosition))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Position은_Position_인스턴스간_위치값_비교가_가능하다() {
        Position one = new Position(0);
        Position theOther = new Position(5);

        assertThat(one.isLessThan(theOther)).isTrue();
    }

    @Test
    void Position은_Position_인스턴스간_위치값_비교시_null을_입력받으면_NPE를_발생시킨다() {
        Position one = new Position(0);

        assertThatThrownBy(() -> one.isLessThan(null))
            .isInstanceOf(NullPointerException.class);
    }

    @Test
    void Position은_다음_위치의_인스턴스를_생성할_수_있다() {
        Position position = new Position(0);
        Position nextPosition = position.next();

        assertThat(nextPosition).isEqualTo(new Position(1));
    }

    @Test
    void 최대_위치에_도달한_Position은_다음_위치의_인스턴스_생성요청_시_예외를_발생시킨다() {
        int maxPosition = 5;
        Position position = new Position(maxPosition);

        assertThatThrownBy(() -> position.next())
            .isInstanceOf(IllegalStateException.class)
            .hasMessage("이미 최대 Position에 도달하여 이동할 수 없습니다.");
    }


}
