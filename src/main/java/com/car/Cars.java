package com.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final String REPORT_FORMAT = "%s : %.0f리터";
    private static final String NEWLINE = System.getProperty("line.separator");

    List<Car> cars = new ArrayList<>();

    public Cars() {
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public String getCarsReport() {
        StringBuilder carsReport = new StringBuilder();
        cars.forEach(car -> {
            carsReport.append(String.format(REPORT_FORMAT, car.getName(), car.getChargeQuantity()));
            carsReport.append(NEWLINE);
        });
        return carsReport.toString();
    }
}
