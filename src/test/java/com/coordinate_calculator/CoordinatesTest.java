package com.coordinate_calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Coordinates 단위테스트")
public class CoordinatesTest {

    @DisplayName("Coordinates 좌표 일급컬렉션은")
    @Nested
    class Nested1 {

        @DisplayName("좌표 개수가 2개이면 직선 거리를 계산한다")
        @Test
        void calculate_line_length_when_coordinates_size_is_two() {
            //given
            Points points = new Points(0, 0, 2, 0);
            Coordinates coordinates = points.toCoordinates();

            //when
            Result result = coordinates.calculate();
            String print = result.print(4);

            //then
            Assertions.assertAll(
                () -> assertThat(print.contains("직선")),
                () -> assertThat(print.contains("길이")),
                () -> assertThat(print.contains("2.0000"))
            );
        }

        @DisplayName("좌표 개수가 4개이면 직사각형 면적을 계산한다")
        @Test
        void calculate_rectangle_area_when_coordinates_size_is_four() {
            //given
            Points points = new Points(0, 0, 2, 0, 0, 2, 2, 2);
            Coordinates coordinates = points.toCoordinates();

            //when
            Result result = coordinates.calculate();
            String print = result.print(4);

            //then
            Assertions.assertAll(
                () -> assertThat(print.contains("사각형")),
                () -> assertThat(print.contains("면적")),
                () -> assertThat(print.contains("4.0000"))
            );
        }
    }
}
