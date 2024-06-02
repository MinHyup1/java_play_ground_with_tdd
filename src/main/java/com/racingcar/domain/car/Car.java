package com.racingcar.domain.car;

import java.util.Objects;

public class Car {
    private final CarName name;
    private Location location;

    public Car(String carName) {
        this.name = new CarName(carName);
        this.location = new Location();
    }

    //for test
    public Car(String carName, Location location) {
        this.name = new CarName(carName);;
        this.location = location;
    }

    public void moveOrStopByRandomNumber(int number) {
        if(number >= 4) {
            this.location.advanceOneStep();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return Objects.equals(name, car.name) && Objects.equals(location, car.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }

    public Location returnLageLocationAfterComparison(Location comparisonLocation) {
        return this.location.returnLageLocation(comparisonLocation);
    }

    public boolean isEqualLocation(Location maxLocation) {
        return this.location.equals(maxLocation);
    }

    public String locationToString() {
        return this.location.toString();
    }

    public String toStringCarName() {
        return this.name.toString();
    }
}
