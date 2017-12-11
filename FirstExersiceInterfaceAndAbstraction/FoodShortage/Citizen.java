package FirstExersiceInterfaceAndAbstraction.FoodShortage;

public class Citizen implements Checker, Buyer {
    private String name;
    private int age;
    private String id;
    private String birthday;
    public static int foodBought = 0;

    public Citizen(String name, int age, String id, String birthday) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    @Override
    public String checker(String finalNumber) {
        if (this.birthday.split("/")[2].equalsIgnoreCase(finalNumber)) {
            return this.birthday;
        }
        return "";
    }

    @Override
    public void buyFood(int food) {
        foodBought += food;
    }
}
