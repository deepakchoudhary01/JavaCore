package org.example.patterns.car_rental.decorator;

import org.example.patterns.car_rental.Car;

public class GPS extends CarDecorator {
    public GPS(Car car) {
        super(car);
    }

    @Override
    public String getDescription() {
        return car.getDescription() + ", GPS";
    }

    @Override
    public double getCost() {
        return car.getCost() + 500;
    }
}
