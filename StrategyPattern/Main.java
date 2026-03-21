package StrategyPattern;

public class Main {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setPaymentStrategy(new UPIpaymentStrategy());
        shoppingCart.checkout(100.0);

        shoppingCart.setPaymentStrategy(new CCPaymentStrategy());
        shoppingCart.checkout(100.0);
    }
}
