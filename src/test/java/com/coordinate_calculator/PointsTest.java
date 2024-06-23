package com.coordinate_calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Points 단위테스트")
public class PointsTest {

    @DisplayName("Points 일급컬렉션은")
    @Nested
    class Nested1 {

        @DisplayName("입력받은 좌표값의 개수가 4개이면 직선에 필요한 좌표의 유효성 검사를 수행한다.")
        @Nested
        class Nested2 {

            @DisplayName("입력받은 좌표값이 직선의 좌표가 아닌 경우 예외를 발생시킨다")
            @Test
            void line_points_exception() {
                assertThatThrownBy(() -> new Points(0, 0, 0, 0))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("서로 다른 좌표를 입력해주세요.");
            }

            @DisplayName("입력받은 좌표값이 유효하면 Points 인스턴스 생성에 성공한다")
            @Test
            void rectangle_points_success() {
                Points points = new Points(0, 0, 2, 0);
                assertThat(points).isNotNull();
            }
        }

        @DisplayName("입력받은 좌표값의 개수가 8개이면 직사각형에 필요한 좌표의 유효성 검사를 수행한다.")
        @Nested
        class Nexted3 {

            @DisplayName("입력받은 좌표값이 직사각형 좌표가 아닌 경우 예외를 발생시킨다")
            @Test
            void rectangle_points_exception() {
                //(0,2)     (2,2)
                //
                //(0,0)  (1,0)
                assertThatThrownBy(() -> new Points(0, 0, 1, 0, 2, 2, 2, 2))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("직사각형 면적만 계산할 수 있습니다.");
            }

            @DisplayName("입력받은 좌표값이 유효하면 Points 인스턴스 생성에 성공한다")
            @Test
            void rectangle_points_success() {
                Points points = new Points(0, 0, 2, 0, 2, 2, 2, 2);
                assertThat(points).isNotNull();
            }
        }

        @DisplayName("입력받은 좌표값 목록을 이용하여 좌표 일급컬렉션을 생성한다.")
        @Test
        void test() {
            Points points = new Points(0, 0, 2, 0, 2, 2, 2, 2);
            Coordinates coordinates = points.toCoordinates();

            assertThat(coordinates).isNotNull();
        }
    }
}
