package com.coordinate_calculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Points 단위테스트")
public class PointsTest {

    @DisplayName("Points_일급컬렉션은")
    @Nested
    class Nested1 {

        @DisplayName("입력받은_value의_개수가_8개이면_직사각형에_필요한_좌표의_유효성_검사를_수행하며")
        @Nested
        class Nexted2 {

            @DisplayName("입력받은 좌표값이 직사각형 좌표가 아닌 경우 예외를 발생시킨다")
            @Test
            void rectangle_exception() {
                //(0,2)     (2,2)
                //
                //(0,0)  (1,0)
                assertThatThrownBy(() -> new Points(0, 0, 1, 0, 2, 2, 2, 2))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("직사각형 면적만 계산할 수 있습니다.");
            }
        }
    }
}
