package panzer.models.vehicles;

import panzer.contracts.Assembler;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;
import panzer.models.miscellaneous.VehicleAssembler;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class Vehicles implements Vehicle {
    private String model;
    private double weight;
    private BigDecimal price;
    private int attack;
    private int defense;
    private int hitPoints;

    private Assembler vehicleAssembler;

    protected Vehicles(String model, double weight, BigDecimal price, int attack, int defense, int hitPoints) {
        setModel(model);
        setWeight(weight);
        setPrice(price);
        setAttack(attack);
        setDefense(defense);
        setHitPoints(hitPoints);
        this.vehicleAssembler = new VehicleAssembler();
    }

    protected void setModel(String model) {
        this.model = model;
    }

    protected void setWeight(double weight) {
        this.weight = weight;
    }

    protected void setPrice(BigDecimal price) {
        this.price = price;
    }

    protected void setAttack(int attack) {
        this.attack = attack;
    }

    protected void setDefense(int defense) {
        this.defense = defense;
    }

    protected void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    @Override
    public double getTotalWeight() {
        return this.vehicleAssembler.getTotalWeight() + this.weight;
    }

    @Override
    public BigDecimal getTotalPrice() {
        return this.vehicleAssembler.getTotalPrice().add(this.price);
    }

    @Override
    public long getTotalAttack() {
        return this.vehicleAssembler.getTotalAttackModification() + this.attack;
    }

    @Override
    public long getTotalDefense() {
        return this.vehicleAssembler.getTotalDefenseModification() + this.defense;
    }

    @Override
    public long getTotalHitPoints() {
        return this.vehicleAssembler.getTotalHitPointModification() + this.hitPoints;
    }

    @Override
    public void addArsenalPart(Part arsenalPart) {
        this.vehicleAssembler.addArsenalPart(arsenalPart);
    }

    @Override
    public void addShellPart(Part shellPart) {
        this.vehicleAssembler.addShellPart(shellPart);
    }

    @Override
    public void addEndurancePart(Part endurancePart) {
        this.vehicleAssembler.addEndurancePart(endurancePart);
    }

    @Override
    public Iterable<Part> getParts() throws NoSuchFieldException, IllegalAccessException {
        LinkedList<Part> allParts = new LinkedList<>();
        Field firstList = this.vehicleAssembler.getClass().getDeclaredField("arsenalParts");
        firstList.setAccessible(true);
        allParts.addAll((List<Part>) firstList.get(this.vehicleAssembler));

        Field secondList = this.vehicleAssembler.getClass().getDeclaredField("shellParts");
        secondList.setAccessible(true);
        allParts.addAll((List<Part>) secondList.get(this.vehicleAssembler));

        Field thirdList = this.vehicleAssembler.getClass().getDeclaredField("enduranceParts");
        thirdList.setAccessible(true);
        allParts.addAll((List<Part>) thirdList.get(this.vehicleAssembler));

        return allParts;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
