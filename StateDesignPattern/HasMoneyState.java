package StateDesignPattern;

public class HasMoneyState implements VendingMachin {
    private final VendingMachineMain machine;

    public HasMoneyState(VendingMachineMain machine) {
        this.machine = machine;
    }

    @Override
    public void insertMoney() {
        System.out.println("Money already inserted");
    }

    @Override
    public void ejectMoney() {
        System.out.println("Money ejected");
        machine.setState(machine.getNoMoneyState());
    }

    @Override
    public void pushButton() {
        System.out.println("Item dispensed");
        machine.setState(machine.getNoMoneyState());
    }
}
