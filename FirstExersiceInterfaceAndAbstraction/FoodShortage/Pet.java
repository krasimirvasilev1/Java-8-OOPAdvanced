package FirstExersiceInterfaceAndAbstraction.FoodShortage;

public class Pet implements Checker {
    private String name;
    private String birthday;

    public Pet(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String checker(String finalNumber) {
        if (this.birthday.split("/")[2].equalsIgnoreCase(finalNumber)){
            return this.birthday;
        }
        return "";
    }
}
