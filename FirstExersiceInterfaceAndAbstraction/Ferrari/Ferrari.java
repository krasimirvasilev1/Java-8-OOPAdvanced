package FirstExersiceInterfaceAndAbstraction.Ferrari;

public class Ferrari implements Car {
    private String model = "488-Spider";
    private String driver;

    public Ferrari(String driver) {
        this.driver = driver;
    }

    public String getModel() {
        return model;
    }

    public String getDriver() {
        return driver;
    }

    @Override
    public String useBrakes() {
        return "Brakes!";
    }

    @Override
    public String pushTheGasPedal() {
        return "Zadu6avam sA!";
    }
}
