package StateDesignPattern;

public class VendingMachineMain {
    private final VendingMachin noMoneyState;
    private final VendingMachin hasMoneyState;

    private VendingMachin currentState;

    public VendingMachineMain() {
        noMoneyState = new NoMoneyState(this);
        hasMoneyState = new HasMoneyState(this);
        currentState = noMoneyState;
    }

    public void setState(VendingMachin state) {
        this.currentState = state;
    }

    public void insertMoney() {
        currentState.insertMoney();
    }

    public void ejectMoney() {
        currentState.ejectMoney();
    }

    public void pushButton() {
        currentState.pushButton();
    }

    public VendingMachin getNoMoneyState() {
        return noMoneyState;
    }

    public VendingMachin getHasMoneyState() {
        return hasMoneyState;
    }
}
