package com.racingcar.validation;

public class Validation {

    public boolean carNameValidation(String carName) {
        if(carName.isEmpty()) {
            return false;
        }
        return carName.length() <= 5;
    }
}
