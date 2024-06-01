package com.racingcar.domain;

import java.util.Objects;

public class Location {
    private int location;

    public Location() {
        this.location = 0;
    }

    //for test
    public Location(int location) {
        this.location = location;
    }

    public void advanceOneStep() {
        this.location++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location location1)) return false;
        return location == location1.location;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }
}
