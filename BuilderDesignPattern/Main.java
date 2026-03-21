package BuilderDesignPattern;

public class Main {
    public static void main(String[] args) {
        Pizza myorder = new Pizza.pizzaBuilder("Thin", "Tomato")
                .setTopping("Pepperoni")
                .setExtraCheese(true)
                .setGlutenFree(false)
                .build();

        Pizza plainorder = new Pizza.pizzaBuilder("Thick", "Barbecue")
                .build();

        System.out.println(myorder.to_string());
            System.out.println(plainorder.to_string());
    }
}
