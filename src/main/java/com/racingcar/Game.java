package com.racingcar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    public void start() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String nameString = br.readLine();
        List<String> names = StringUtils.separate(nameString, ",");

        Cars cars = new Cars(names);

        System.out.println("시도할 회수는 몇회인가요?");
        String countString = br.readLine();
        Integer count = Integer.valueOf(countString);


        for (int i = 0; i < count; i++) {
            cars.move();
            Points points = cars.getCurrentPoints();

        }
    }
}
