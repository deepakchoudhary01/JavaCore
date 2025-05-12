package org.example.patterns.car_rental;

public class Sedan implements Car {
    @Override
    public String getDescription() {
        return "Sedan";
    }

    @Override
    public double getCost() {
        return 3000;
    }
}
