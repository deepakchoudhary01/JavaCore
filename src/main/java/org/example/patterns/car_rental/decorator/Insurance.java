package org.example.patterns.car_rental.decorator;

import org.example.patterns.car_rental.Car;

public class Insurance extends CarDecorator {
    public Insurance(Car car) {
        super(car);
    }

    @Override
    public String getDescription() {
        return car.getDescription() + ", Insurance";
    }

    @Override
    public double getCost() {
        return car.getCost() + 1000;
    }
}
