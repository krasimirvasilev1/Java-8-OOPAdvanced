package FirstExersiceInterfaceAndAbstraction.BirthdayCelebrations;

public class Citizen implements Checker {
    private String name;
    private int age;
    private String id;
    private String birthday;

    public Citizen(String name, int age, String id , String birthday) {
        this.name = name;
        this.age = age;
        this.id = id;
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
