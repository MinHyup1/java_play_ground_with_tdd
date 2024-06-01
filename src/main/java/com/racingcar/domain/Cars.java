package com.racingcar.domain;

import com.racingcar.domain.car.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> carList = new ArrayList<Car>();
    public Cars(String carNames) {
        //자동차 명 중복 제거
        Set<String> collect = Arrays.stream(carNames.split(",")).collect(Collectors.toSet());

        for (String carName : collect) {
            this.carList.add(new Car(carName));
        }
    }

    public void allMoveForward() {
//        for (Car car : carList) {
//            car.moveOrStopByRandomNumber();
//        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<Car> getWinner() {
        List<Car> winners = new ArrayList<>();
        // 점수를 기준으로 내림차순 정렬
//        this.carList.sort(Comparator.comparingInt(Car::getLocation).reversed());
//
//        // 등수를 매기기 위한 변수
//        int rank = 1;
//        int prevScore = -1;
//
//        for (int i = 0; i < carList.size(); i++) {
//            Car car = carList.get(i);
//            if (car.getLocation() != prevScore) {
//                rank = i + 1; // 현재 인덱스 + 1로 등수 설정
//            }
//            if (rank == 1) {
//                winners.add(car);
//            }
//            prevScore = car.getLocation();
//        }
        return winners;
    }
}
