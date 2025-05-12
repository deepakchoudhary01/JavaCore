package org.example.patterns.ecommerce;

public class UpiPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " using UPI");
    }
}
