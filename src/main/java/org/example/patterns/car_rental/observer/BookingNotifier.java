package org.example.patterns.car_rental.observer;

import java.util.ArrayList;
import java.util.List;

public class BookingNotifier {
    private List<Observer> observers=new ArrayList<>();
    public void register(Observer observer) {
        observers.add(observer);
    }
    public void notifyAllObservers(String message) {
        observers.forEach(observer -> observer.update(message));
    }
}
