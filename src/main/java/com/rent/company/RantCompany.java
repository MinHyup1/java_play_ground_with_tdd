package com.rent.company;

import com.car.Car;
import com.car.Cars;


public class RantCompany implements Company{
    private Cars cars;

    public RantCompany() {
        this.cars = new Cars();
    }

    public void addCar(Car car) {
        this.cars.addCar(car);
    }

    @Override
    public String generateReport() {
        return this.cars.getCarsReport();
    }
}
