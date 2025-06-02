package org.example.patterns.ecommerce;

public class Main {
    public static void main(String[] args) {
        CheckoutService service=new CheckoutService();

        service.checkout("UPI", 100);
        service.checkout("wallet", 200);
        service.checkout("credit card", 300);
    }
}
