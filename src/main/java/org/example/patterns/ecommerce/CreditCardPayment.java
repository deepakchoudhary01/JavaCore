package org.example.patterns.ecommerce;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " using credit card");
    }
}
