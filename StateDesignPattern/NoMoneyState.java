package StateDesignPattern;

public class NoMoneyState implements VendingMachin {
    private final VendingMachineMain machine;

    public NoMoneyState(VendingMachineMain machine) {
        this.machine = machine;
    }

    @Override
    public void insertMoney() {
        System.out.println("Money inserted");
        machine.setState(machine.getHasMoneyState());
    }

    @Override
    public void ejectMoney() {
        System.out.println("No money to eject");
    }

    @Override
    public void pushButton() {
        System.out.println("Please insert money first");
    }
}
