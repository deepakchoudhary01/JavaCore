package org.example.patterns.car_rental;

import org.example.patterns.car_rental.decorator.GPS;
import org.example.patterns.car_rental.decorator.Insurance;
import org.example.patterns.car_rental.observer.AdminObserver;
import org.example.patterns.car_rental.observer.BookingNotifier;
import org.example.patterns.car_rental.singleton.InventoryManager;

public class MAin {
    public static void main(String[] args) {
        CarFactory factory=new ConcreteCarFactory();
        BookingNotifier notifier=new BookingNotifier();
        notifier.register(new AdminObserver("admin1"));
        notifier.register(new AdminObserver("admin2"));

        String type="sedan";
        InventoryManager inventory=InventoryManager.getInstance();

        if (inventory.bookCar(type)) {
            Car car=factory.createCar(type);
            car=new GPS(car);
            car=new Insurance(car);

            notifier.notifyAllObservers(type.toUpperCase()+ " booked!");
            System.out.println("Car: "+car.getDescription());
            System.out.println("Cost: "+car.getCost());
        } else {
            System.out.println("Car type "+ type +" is not available.");
        }
    }
}
