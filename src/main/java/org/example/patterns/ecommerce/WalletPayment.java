package org.example.patterns.ecommerce;

public class WalletPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " using wallet");
    }
}
