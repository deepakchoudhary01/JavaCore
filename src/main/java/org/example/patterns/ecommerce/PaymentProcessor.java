package org.example.patterns.ecommerce;

public class PaymentProcessor {
    private static PaymentProcessor instance;

    private PaymentProcessor() {
    }

    public static PaymentProcessor getInstance() {
        if (instance == null) {
            synchronized (PaymentProcessor.class) {
                if (instance == null) {
                    instance = new PaymentProcessor();
                }
            }
        }
        return instance;
    }

    public void processPayment(PaymentStrategy strategy, double amount) {
        strategy.pay(amount);
    }
}
