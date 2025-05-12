package org.example.patterns.car_rental;

public class SUV implements Car {
    @Override
    public String getDescription() {
        return "SUV";
    }

    @Override
    public double getCost() {
        return 5000;
    }
}
