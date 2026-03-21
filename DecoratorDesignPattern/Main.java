package DecoratorDesignPattern;

public class Main {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffe();
        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " costs $" + coffee.getCost());
        System.out.println("Is this coffee decaf? " + coffee.getDescription());


    }
}
