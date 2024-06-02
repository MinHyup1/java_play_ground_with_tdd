package com.racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Print {

    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String WINNER_DELIMITER = ", ";

    public static void winners(List<String> winners) {
        String winnerStr = winners.stream()
            .collect(Collectors.joining(WINNER_DELIMITER));

        System.out.println(winnerStr + WINNER_MESSAGE);
    }
}
