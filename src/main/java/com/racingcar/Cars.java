package com.racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = createCars(carNames);
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public void move() {
        for (Car car : cars) {
            int randomNumber = RandomNumberUtils.generate();
            car.move(randomNumber);
        }
    }

    public Points getCurrentPoints() {
        Points points = new Points();
        for (Car car : cars) {
            points.add(car.getName(), car.getPoint());
        }

        return points;
    }
}
