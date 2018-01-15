package panzer.models.vehicles;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Vanguard extends Vehicles {

    public Vanguard(String model, double weight, BigDecimal price, int attack, int defense, int hitPoints) {
        super(model, weight, price, attack, defense, hitPoints);
    }

    @Override
    protected void setWeight(double weight) {
        super.setWeight(weight * 2);
    }

    @Override
    protected void setAttack(int attack) {
        super.setAttack(attack - (int) (attack * 0.25));
    }

    @Override
    protected void setDefense(int defense) {
        super.setDefense(defense + (int) (defense * 0.50));
    }

    @Override
    protected void setHitPoints(int hitPoints) {
        super.setHitPoints(hitPoints + (int) (hitPoints * 0.75));
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Vanguard - %s%n", super.getModel()));
        builder.append(String.format("Total Weight: %.3f%n", super.getTotalWeight()));
        builder.append(String.format("Total Price: %.3f%n", super.getTotalPrice()));
        builder.append(String.format("Attack: %d%n", super.getTotalAttack()));
        builder.append(String.format("Defense: %d%n", super.getTotalDefense()));
        builder.append(String.format("HitPoints: %d%n",super.getTotalHitPoints()));
        builder.append("Parts: ");
        List<String> allParts = new ArrayList<>();
        try {
            this.getParts().forEach(x -> allParts.add(x.getModel()));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        if (allParts.isEmpty()) {
            builder.append("None");
        } else {
            builder.append(String.join(", ", allParts));
        }

        return builder.toString();
    }
}
