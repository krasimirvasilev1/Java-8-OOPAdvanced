package FirstExersiceInterfaceAndAbstraction.FoodShortage;

public class Rebel implements Buyer{
    private String name;
    private int age;
    private String group;
    public static int foodBought = 0;

    public Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    @Override
    public void buyFood(int food) {
        foodBought += food;
    }
}
