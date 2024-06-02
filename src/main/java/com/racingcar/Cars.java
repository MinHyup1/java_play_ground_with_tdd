package com.racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        Objects.requireNonNull(cars);

        this.cars = new ArrayList<>(cars);
    }

    public List<String> findWinners() {
        List<Car> winner = new ArrayList<>();
        for (Car car : cars) {
            addWinner(car, winner);
        }

        return winner.stream()
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    private void addWinner(Car car, List<Car> winner) {
        Position carPosition = car.getPosition();
        if (Position.MAX.equals(carPosition)) {
            winner.add(car);
        }
    }
}
