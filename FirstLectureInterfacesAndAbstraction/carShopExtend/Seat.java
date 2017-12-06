package FirstLectureInterfacesAndAbstraction.carShopExtend;

import FirstLectureInterfacesAndAbstraction.carShop.Car;

public class Seat implements Sellable {
    private String model;
    private String colour;
    private int horsePower;
    private String countryProduced;
    private double price;

    public Seat(String model, String colour, Integer horsePower, String countryProduced, Double price) {
        this.model = model;
        this.colour = colour;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
        this.price = price;
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

    @Override
    public double getPrice() {
        return this.price;
    }
}
