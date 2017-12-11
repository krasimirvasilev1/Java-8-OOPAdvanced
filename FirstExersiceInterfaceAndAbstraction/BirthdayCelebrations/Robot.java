package FirstExersiceInterfaceAndAbstraction.BirthdayCelebrations;

public class Robot implements Checker {
    private String model;
    private String id;

    public Robot(String model, String id) {
        this.model = model;
        this.id = id;
    }

    @Override
    public String checker(String finalNumbers) {
        return "";
    }
}
