package org.example.patterns.ecommerce;

public class PaymentFactory {
    public static PaymentStrategy getPaymentStrategy(String paymentType) {
        switch (paymentType.toLowerCase()) {
            case "upi":
                return new UpiPayment();
            case "wallet":
                return new WalletPayment();
            case "credit card":
                return new CreditCardPayment();
            default:
                throw new IllegalArgumentException("Invalid payment type: " + paymentType);
        }
    }
}
