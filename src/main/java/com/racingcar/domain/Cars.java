package com.racingcar.domain;

import com.racingcar.domain.car.Car;
import com.racingcar.domain.car.Location;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> carList = new ArrayList<Car>();

    public Cars(String carNames) {
        //자동차 명 중복 제거
        Set<String> carNameSet = Arrays.stream(carNames.split(",")).collect(Collectors.toSet());
        this.carList = carNameSet.stream().map(Car::new).collect(Collectors.toList());
    }

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<Car> getWinner() {
        return getCarsByLocation(getMaxLocation());
    }

    private List<Car> getCarsByLocation(final Location maxLocation) {
        return this.carList.stream()
                .filter(car -> car.isEqualLocation(maxLocation))
                .collect(Collectors.toList());
    }

    private Location getMaxLocation() {
        Location maxLocation = null;
        for (int i = 0; i < this.carList.size() - 1; i++) {
            maxLocation = this.carList.get(i).returnLageLocationAfterComparison(this.carList.get(i + 1));
        }
        return maxLocation;
    }
}
