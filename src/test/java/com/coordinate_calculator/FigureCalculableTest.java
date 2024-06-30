package com.coordinate_calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("FigureCalculatorFactory 단위테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class FigureCalculableTest {

    @Test
    void 도형_계산기는_Figure을_리턴한다() {
        Coordinate one = new Coordinate(new Point(0), new Point(0));
        Coordinate two = new Coordinate(new Point(1), new Point(2));

        FigureCalculable calculator = FigureCalculatorFactory.create(List.of(one, two));

        assertThat(calculator.calculate()).isInstanceOf(Figure.class);
    }

    @Test
    void 직선_계산기가_리턴하는_인스턴스_타입은_Line이다() {
        Coordinate one = new Coordinate(new Point(0), new Point(0));
        Coordinate two = new Coordinate(new Point(1), new Point(2));
        FigureCalculable lineCalculator = FigureCalculatorFactory.create(List.of(one, two));

        Figure figure = lineCalculator.calculate();
        assertThat(figure).isInstanceOf(Line.class);
    }

    @Test
    void 삼각형_계산기가_리턴하는_인스턴스_타입은_Triangle이다() {
        Coordinate one = new Coordinate(new Point(0), new Point(0));
        Coordinate two = new Coordinate(new Point(2), new Point(0));
        Coordinate three = new Coordinate(new Point(0), new Point(2));
        FigureCalculable triangleCalculator = FigureCalculatorFactory.create(List.of(one, two, three));

        Figure figure = triangleCalculator.calculate();
        assertThat(figure).isInstanceOf(Triangle.class);
    }

    @Test
    void 직사각형_계산기가_리턴하는_인스턴스_타입은_Rectangle이다() {
        Coordinate one = new Coordinate(new Point(0), new Point(0));
        Coordinate two = new Coordinate(new Point(1), new Point(2));
        Coordinate three = new Coordinate(new Point(0), new Point(2));
        Coordinate four = new Coordinate(new Point(2), new Point(2));
        FigureCalculable rectangleCalculator = FigureCalculatorFactory.create(List.of(one, two, three, four));

        Figure figure = rectangleCalculator.calculate();
        assertThat(figure).isInstanceOf(Rectangle.class);
    }

    @MethodSource("getTriangleCoordinates")
    @ParameterizedTest
    void 삼각형_계산기_계산_검증(int a_x, int a_y, int b_x, int b_y, int c_x, int c_y, double result) {
        Coordinate one = new Coordinate(new Point(a_x), new Point(a_y));
        Coordinate two = new Coordinate(new Point(b_x), new Point(b_y));
        Coordinate three = new Coordinate(new Point(c_x), new Point(c_y));
        FigureCalculable rectangleCalculator = FigureCalculatorFactory.create(List.of(one, two, three));

        Figure figure = rectangleCalculator.calculate();

        Double calculateResult = figure.getCalculateResult(0);
        assertThat(calculateResult).isEqualTo(result);
    }

    private static Stream<Arguments> getTriangleCoordinates() {
        return Stream.of(
            Arguments.arguments(0, 0, 2, 0, 0, 2, 2.0),
            Arguments.arguments(1, 1, 2, 2, 2, 0, 1.0)
        );
    }
}

