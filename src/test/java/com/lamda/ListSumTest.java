package com.lamda;

import org.junit.jupiter.api.Test;
import training.lamda.Conditional;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ListSumTest {

   final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

   @Test
   void 리스트에_담긴_숫자중_3이상인_숫자의_합계() {
       assertThat(sumAll(numbers , (number) -> number >= 3)).isEqualTo(18);
   }

    @Test
    void 리스트에_담긴_모든_숫자의_합계() {
        assertThat(sumAll(numbers , (number) -> true)).isEqualTo(21);
    }

    public int sumAll(List<Integer> numbers, Conditional c) {
        return numbers.stream().filter(c::test).mapToInt(Integer::intValue).sum();
    }

}
