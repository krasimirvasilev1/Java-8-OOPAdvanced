package FirstLectureInterfacesAndAbstraction.carShopExtend;

public class Audi implements Rentable {
    private String model;
    private String colour;
    private int horsePower;
    private String countryProduced;
    private int minRentDay;
    private Double pricePerDay;

    public Audi(String model, String colour, Integer horsePower, String countryProduced, Integer minRentDay, Double pricePerDay) {
        this.model = model;
        this.colour = colour;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public int getMinRentDay() {
        return this.minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.colour;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires",this.model,this.countryProduced,Car.TIRES);
    }
}
