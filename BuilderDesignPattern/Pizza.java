package BuilderDesignPattern;

public class Pizza {
    private final String crust;

    private final String sauce;
    private final String topping;
    private final boolean extraCheese;
    private final boolean glutenFree;

    public Pizza(String crust, String sauce, String topping, boolean extraCheese, boolean glutenFree) {
        this.crust = crust;
        this.sauce = sauce;
        this.topping = topping;
        this.extraCheese = extraCheese;
        this.glutenFree = glutenFree;
    }

    public String to_string() {
        return "Pizza with " + crust + " crust, " + sauce + " sauce, " + topping + " topping, "
                + (extraCheese ? "extra cheese, " : "") + (glutenFree ? "gluten-free" : "");
    }

    public static class pizzaBuilder{
        private final String crust;
        private final String sauce;
        private String topping;
        private boolean extraCheese;
        private boolean glutenFree;

        public pizzaBuilder(String crust, String sauce) {
            this.crust = crust;
            this.sauce = sauce;
        }

        public pizzaBuilder setTopping(String topping) {
            this.topping = topping;
            return this;
        }

        public pizzaBuilder setExtraCheese(boolean extraCheese) {
            this.extraCheese = extraCheese;
            return this;
        }

        public pizzaBuilder setGlutenFree(boolean glutenFree) {
            this.glutenFree = glutenFree;
            return this;
        }

        public Pizza build() {
            return new Pizza(crust, sauce, topping, extraCheese, glutenFree);
        }
    }
}
