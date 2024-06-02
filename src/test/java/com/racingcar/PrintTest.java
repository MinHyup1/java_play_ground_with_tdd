package com.racingcar;

import java.util.List;
import org.junit.jupiter.api.Test;

public class PrintTest {

    @Test
    void test() {
        Print.winners(List.of("자동차A", "자동차B"));
    }
}
