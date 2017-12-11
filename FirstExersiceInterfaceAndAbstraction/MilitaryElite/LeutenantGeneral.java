package FirstExersiceInterfaceAndAbstraction.MilitaryElite;

import java.util.ArrayList;
import java.util.List;

public class LeutenantGeneral extends Private implements ILeutenantGeneral {
    private List<Private> privates;

    public LeutenantGeneral(String id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    @Override
    public void addPrivate(Private soldier){
        this.privates.add(soldier);
    }

    @Override
    public List<Private> getPrivates() {
        return this.privates;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Name: %s %s Id: %s Salary: %.2f%n",getFirstName(),getLastName(),getId(),getSalary()));
        builder.append(String.format("Privates:%n"));
        for (Private aPrivate : privates) {
            builder.append("  "+aPrivate);
        }
        return builder.toString();
    }
}
