package FirstExersiceInterfaceAndAbstraction.BorderControl;

public class Citizen implements Checker {
    private String name;
    private int age;
    private String id;

    public Citizen(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public String checker(String finalNumbers) {
        if (this.id.substring(this.id.length() - finalNumbers.length(),this.id.length()).equalsIgnoreCase(finalNumbers)){
            return this.id;
        }
        return "";
    }
}
