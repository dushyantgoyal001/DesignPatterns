package StrategyPattern;

public class CCPaymentStrategy implements PaymentStrategy {
    @Override
    public void pay(double amount) {

        System.out.println("Paid " + amount*1.2 + " using Credit Card with Extra 20%" );
    }
}
