package FirstExersiceInterfaceAndAbstraction.BorderControl;

public class Robot implements Checker {
    private String model;
    private String id;

    public Robot(String model, String id) {
        this.model = model;
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
