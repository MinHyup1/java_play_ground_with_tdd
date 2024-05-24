package com.racingcar.domain;

import com.racingcar.validation.Validation;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> carList = new ArrayList<Car>();
    public Cars(String carNames) {
        Validation validation = new Validation();

        for (String carName : carNames.split(",")) {
            validation.carNameValidation(carName);
            this.carList.add(new Car(carName));
        }
    }

    public List<Car> getCarList() {
        return carList;
    }
}
