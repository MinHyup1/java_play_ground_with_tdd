package com.racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CarsTest {

    @Test
    void 자동차_일급컬렉션은_우승자를_응답할_수_있다() {
        Cars cars = new Cars(List.of(
            new Car("자동차1", 0),
            new Car("자동차2", 4),
            new Car("자동차3", 5)));

        List<Name> winners = cars.findWinners();
        List<String> names = winners.stream()
            .map(Name::getName)
            .collect(Collectors.toList());

        assertThat(names).containsOnly("자동차3");
    }
}
