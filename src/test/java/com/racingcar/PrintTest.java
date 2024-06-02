package com.racingcar;

import java.util.List;
import org.junit.jupiter.api.Test;

public class PrintTest {

    @Test
    void test() {
        Print.winners(List.of("자동차A", "자동차B"));
    }

    @Test
    void positions() {
        Cars cars = new Cars(List.of(
            new Car("자동차1", 3),
            new Car("자동차2", 2),
            new Car("자동차3", 4)));

        List<CarPosition> positions = cars.getCurrentPositions();

        Print.positions(positions);
    }
}
