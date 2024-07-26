package com.lamda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StreamMethodTest {

    final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    @Test
    void List에_담긴_모든_숫자_중_3보다_큰_숫자를_2배_한_후_모든_값의_합을_구한다 () {
        assertThat(numbers.stream().filter(number -> number > 3).reduce(Integer::sum).get()).isEqualTo(15);
    }
}
