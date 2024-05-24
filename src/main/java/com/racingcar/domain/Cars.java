package com.racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> carList = new ArrayList<Car>();
    public Cars(String carNames) {
        for (String carName : carNames.split(",")) {
            this.carList.add(new Car(carName));
        }
    }

    public List<Car> getCarList() {
        return carList;
    }
}
