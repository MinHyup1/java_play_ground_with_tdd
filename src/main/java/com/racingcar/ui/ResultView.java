package com.racingcar.ui;

import com.racingcar.domain.Cars;
import com.racingcar.domain.car.Car;

import java.util.List;

public class ResultView {
    public void printResults(Cars cars, int times) {
        printEmptyLine();
        System.out.println("실행 결과");
        for (int i = 0; i <times; i++) {
            printEmptyLine();
            cars.moveAll();
            printCarsLocationResult(cars);
        }
        printWinners(cars);
    }

    private void printWinners(Cars cars) {
        List<Car> winners = cars.getWinner();
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).toStringCarName());
            if(i != winners.size() -1) {
                System.out.print(",");
            }
        }
        System.out.println(" 가 최종 우승했습니다.");
    }

    private void printCarsLocationResult(Cars cars) {
        cars.getCarList().forEach(this::printCartLocation);
    }

    private void printCartLocation(Car car) {
        System.out.printf("[%-5s]",car.toStringCarName());
        System.out.print(" : ");
        System.out.print(car.locationToString());
        printEmptyLine();
    }

    private void printEmptyLine() {
        System.out.println();
    }
}
