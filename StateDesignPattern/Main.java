package StateDesignPattern;

public class Main {
    public static void main(String[] args) {
        VendingMachineMain vendingMachine = new VendingMachineMain();
        vendingMachine.insertMoney();
        vendingMachine.pushButton();
        vendingMachine.ejectMoney();
    }
}
