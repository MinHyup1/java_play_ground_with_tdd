package com.racingcar.validation;

public class Validation {

    public void carNameValidation(String carName) {
        if(carName.isEmpty()) {
            throw new RuntimeException("carName is not Empty");
        }

        if(carName.length() > 5) {
            throw new RuntimeException("carName length is not great than 5");
        }
    }
}
