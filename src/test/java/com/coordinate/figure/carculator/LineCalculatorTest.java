package com.coordinate.figure.carculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
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
    @CsvSource(value = {"(0,0)-(5,0)-(1,2):5"}, delimiter = ':')
    void 세게의_좌표는_직선거리계산기를_이용할_수_없다(String input, double expected) {
        //given
        String coordinatesToString = input;

        //when
        LineCalculator lineCalculator = new LineCalculator();

        //then
        assertThatThrownBy(() -> {
            double distance = lineCalculator.calculate(coordinatesToString);
        }).isInstanceOf(RuntimeException.class);


    }

    @ParameterizedTest
    @CsvSource(value = {"(0,0)-(0,4)-(4,0)-(4,4):16","(0,0)-(0,5)-(4,0)-(4,5):20"}, delimiter = ':')
    void 주어진_네개의_좌표로_직사각형_면젹을_계산할_수_있다(String input, double expected) {
        //given
        String coordinatesToString = input;

        //when
        RectangleCalculator rectangleCalculator = new RectangleCalculator();
        double area = rectangleCalculator.calculate(coordinatesToString);

        //then
        assertThat(area).isEqualTo(expected, offset(0.00099));
    }

    @ParameterizedTest
    @CsvSource(value = {"(0,0)-(0,0)-(0,0)-(0,0):0","(1,0)-(2,5)-(5,0)-(24,5):99"}, delimiter = ':')
    void 주어진_네개의_좌표가_직사각형이_아니라면_예외가_발생한다(String input, double expected) {
        //given
        String coordinatesToString = input;

        //when
        RectangleCalculator rectangleCalculator = new RectangleCalculator();

        //then
        assertThatThrownBy(() -> {
            double area = rectangleCalculator.calculate(coordinatesToString);
        }).isInstanceOf(RuntimeException.class);
    }
}