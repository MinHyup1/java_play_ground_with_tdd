package com.racingcar.domain.car;

import java.util.Objects;

public class CarName {
    private String carName;

    public CarName(String carName) {
        if(carName.isEmpty()) {
            throw new RuntimeException("carName is not Empty");
        }

        if(carName.length() > 5) {
            throw new RuntimeException("carName length is not great than 5");
        }

        this.carName = carName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarName carName1)) return false;
        return Objects.equals(carName, carName1.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}
