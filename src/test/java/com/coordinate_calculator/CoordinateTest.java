package com.coordinate_calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("Coordinate 단위테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CoordinateTest {

    @Test
    void 좌표는_다른_좌표를_전달_받아_거리를_계산할_수_있다() {
        //given
        Coordinate one = new Coordinate(0, 0);
        Coordinate theOther = new Coordinate(1, 2);
        double distanceResult = Math.sqrt(Math.pow(1 - 0, 2) + Math.pow(2 - 0, 2));

        //when
        Double distance = one.calculateDistance(theOther);

        //then
        Assertions.assertEquals(distance, distanceResult, 0.001, "(0,0), (1,2)의 직선 거리는 2.236");
    }
}
