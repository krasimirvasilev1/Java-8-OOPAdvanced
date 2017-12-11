package FirstExersiceInterfaceAndAbstraction.MilitaryElite;

import java.util.ArrayList;
import java.util.List;

public class Engineer extends SpecialisedSoldier implements IEngineer {
    private List<Repair> repairs;

    public Engineer(String id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
    }

    @Override
    public void addRepair(Repair repair){
        this.repairs.add(repair);
    }

    @Override
    public List<Repair> getRepairs() {
        return this.repairs;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Name: %s %s Id: %s Salary: %.2f%n",getFirstName(),getLastName(),getId(),getSalary()));
        builder.append(String.format("Corps: %s%n",getCorps()));
        builder.append(String.format("Repairs:%n"));
        for (Repair repair : getRepairs()) {
            builder.append(repair);
        }
        return builder.toString();
    }
}
