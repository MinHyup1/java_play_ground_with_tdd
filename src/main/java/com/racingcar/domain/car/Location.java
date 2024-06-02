package com.racingcar.domain.car;

import java.util.Objects;

public class Location {
    private int location;

    public Location() {
        this.location = 0;
    }

    public Location(int location) {
        this.location = location;
    }

    public void advanceOneStep() {
        this.location++;
    }

    public Location returnLageLocation(Location location) {
        return new Location(Math.max(this.location, location.location));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location location1)) return false;
        return location == location1.location;
    }

    @Override
    public String toString() {
        String locationDash = "";
        for (int i = 0; i < this.location; i++) {
            locationDash += "-";
        }
        return locationDash;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }


}
