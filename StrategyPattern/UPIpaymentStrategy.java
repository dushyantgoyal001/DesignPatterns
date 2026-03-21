package StrategyPattern;

public class UPIpaymentStrategy implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI" );
    }
}
