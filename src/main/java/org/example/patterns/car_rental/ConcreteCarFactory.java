package org.example.patterns.car_rental;

public class ConcreteCarFactory implements CarFactory{
    @Override
    public Car createCar(String carType) {
        switch (carType.toLowerCase()) {
            case "sedan":
                return new Sedan();
            case "suv":
                return new SUV();
            default: throw new IllegalArgumentException("Invalid car type: " + carType);
        }
    }
}
