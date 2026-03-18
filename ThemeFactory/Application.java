package ThemeFactory;

public class Application {
    private Button button;
    private CheckBox checkBox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkBox = factory.createCheckBox();
    }
    public void render() {
        button.paint();
        checkBox.render();
    }

    public static void main(String[] args) {
        System.out.println("--- Abstract Factory: Mac Theme ---");
        Application macApp = new Application(new MacFactory());
        macApp.render();

        System.out.println("\n--- Abstract Factory: Windows Theme ---");
        Application winApp = new Application(new WindowsFactory());
        winApp.render();
    }
}
