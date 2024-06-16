package com.coordinate.figure.carculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.offset;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


class LineCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"(0,0)-(5,0):5","(0,1)-(1,2):1.4142","(10,10)-(15,15):7.0710","(0,0)-(0,0):0","(0,0)-(24,24):33.9411"}, delimiter = ':')
    void 주어진_두개의_좌표로_직선거리를_계산할_수_있다(String input, double expected) {
        //given
        String coordinatesToString = input;

        //when
        LineCalculator lineCalculator = new LineCalculator();
        double distance = lineCalculator.calculate(coordinatesToString);

        //then
        assertThat(distance).isEqualTo(expected, offset(0.00099));
    }

    @ParameterizedTest
    @CsvSource(value = {"(0,0)-(5,0)(0,1)-(1,2):5"}, delimiter = ':')
    void 주어진_네개의_좌표로_직사각형_면젹을_계산할_수_있다(String input, double expected) {
        //given
        String coordinatesToString = input;

        //when
        LineCalculator lineCalculator = new LineCalculator();
        double distance = lineCalculator.calculate(coordinatesToString);

        //then
        assertThat(distance).isEqualTo(expected, offset(0.00099));
    }
}