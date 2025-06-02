package org.example.patterns.car_rental.decorator;

import org.example.patterns.car_rental.Car;

public abstract class CarDecorator implements Car {
    protected Car car;

    public CarDecorator(Car car) {
        this.car = car;
    }
}
