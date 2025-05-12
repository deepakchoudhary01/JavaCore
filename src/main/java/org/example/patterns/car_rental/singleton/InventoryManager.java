package org.example.patterns.car_rental.singleton;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    private static InventoryManager instance;
    private Map<String,Integer> inventory = new HashMap<>();

    private InventoryManager() {
        inventory.put("SEDAN", 10);
        inventory.put("SUV", 5);
    }

    public static InventoryManager getInstance() {
        if (instance == null) {
            synchronized (InventoryManager.class) {
                if (instance == null) {
                    instance = new InventoryManager();
                }
            }
        }
        return instance;
    }

    public boolean bookCar(String carType) {
        carType = carType.toUpperCase();
        int count = inventory.getOrDefault(carType, 0);
        if (count == 0) {
            return false;
        }
        inventory.put(carType, count - 1);
        return true;
    }
}
