package org.example.patterns.ecommerce;

public class CheckoutService {
    public void checkout(String paymentType, double amount) {
        PaymentStrategy strategy = PaymentFactory.getPaymentStrategy(paymentType);
        PaymentProcessor processor = PaymentProcessor.getInstance();
        processor.processPayment(strategy, amount);
    }
}
