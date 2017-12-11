package FirstExersiceInterfaceAndAbstraction.MilitaryElite;

import java.util.ArrayList;
import java.util.List;

public class Commando extends SpecialisedSoldier implements ICommando {
    private List<Mission> missions;

    public Commando(String id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new ArrayList<>();
    }

    @Override
    public void addMission(Mission mission){
        this.missions.add(mission);
    }

    @Override
    public List<Mission> getMissions() {
        return this.missions;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Name: %s %s Id: %s Salary: %.2f%n",getFirstName(),getLastName(),getId(),getSalary()));
        builder.append(String.format("Corps: %s%n",getCorps()));
        builder.append(String.format("Missions:%n"));
        for (Mission mission : missions) {
            builder.append(mission);
        }
        return builder.toString();
    }
}
