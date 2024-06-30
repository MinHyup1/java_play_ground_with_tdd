package com.coordinate_calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

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
}

