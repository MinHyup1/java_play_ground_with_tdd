package com.coordinate_calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("FigureCalculatorFactory 단위테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class FigureCalculatorFactoryTest {

    @Nested
    class FigureCalculatorFactory는 {

        @Test
        void 좌표를_두개_주입_받으면_직선_계산기를_생성한다() {
            Coordinate one = new Coordinate(new Point(0), new Point(0));
            Coordinate two = new Coordinate(new Point(1), new Point(2));

            FigureCalculable calculator = FigureCalculatorFactory.create(List.of(one, two));

            assertThat(calculator).isInstanceOf(LineCalculator.class);
        }

        @Test
        void 좌표를_세개_주입_받으면_삼각형_계산기를_생성한다() {
            Coordinate one = new Coordinate(new Point(0), new Point(0));
            Coordinate two = new Coordinate(new Point(2), new Point(0));
            Coordinate three = new Coordinate(new Point(0), new Point(2));

            FigureCalculable calculator = FigureCalculatorFactory.create(List.of(one, two, three));

            assertThat(calculator).isInstanceOf(TriangleCalculator.class);
        }

        @Test
        void 좌표를_네개_주입_받으면_직사각형_계산기를_생성한다() {
            Coordinate one = new Coordinate(new Point(0), new Point(0));
            Coordinate two = new Coordinate(new Point(2), new Point(0));
            Coordinate three = new Coordinate(new Point(0), new Point(2));
            Coordinate four = new Coordinate(new Point(2), new Point(2));

            FigureCalculable calculator = FigureCalculatorFactory.create(List.of(one, two, three, four));

            assertThat(calculator).isInstanceOf(RectangleCalculator.class);
        }
    }
}
