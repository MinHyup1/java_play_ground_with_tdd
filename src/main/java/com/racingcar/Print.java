package com.racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Print {

    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String WINNER_DELIMITER = ", ";

    private static final String POSITION_DELIMITER = " : ";
    private static final String POSITION_BAR = "-";

    public static void winners(List<String> winners) {
        String winnerStr = winners.stream()
            .collect(Collectors.joining(WINNER_DELIMITER));

        System.out.println(winnerStr + WINNER_MESSAGE);
    }

    public static void positions(List<CarPosition> positions) {
        for (CarPosition position : positions) {
            String positionBars = POSITION_BAR.repeat(position.getPosition());
            StringBuilder sb = new StringBuilder()
                .append(position.getName()).append(POSITION_DELIMITER).append(positionBars);
            System.out.println(sb.toString());
        }

        System.out.println();
    }
}
