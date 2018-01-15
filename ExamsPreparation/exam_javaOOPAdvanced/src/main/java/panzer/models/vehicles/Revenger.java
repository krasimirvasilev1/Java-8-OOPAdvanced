package panzer.models.vehicles;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Revenger extends Vehicles {

    public Revenger(String model, double weight, BigDecimal price, int attack, int defense, int hitPoints) {
        super(model, weight, price, attack, defense, hitPoints);
    }

    @Override
    protected void setPrice(BigDecimal price) {
        super.setPrice(price.add(price.multiply(new BigDecimal(0.50))));
    }

    @Override
    protected void setAttack(int attack) {
        super.setAttack(attack + (int)(attack * 1.50));
    }

    @Override
    protected void setDefense(int defense) {
        super.setDefense(defense - (int)(defense * 0.50));
    }

    @Override
    protected void setHitPoints(int hitPoints) {
        super.setHitPoints(hitPoints - (int)(hitPoints * 0.50));
    }


//    @Override
//public double getTotalWeight() {
//    return this.vehicleAssembler.getTotalWeight();
//}
//
//    @Override
//    public BigDecimal getTotalPrice() {
//        return this.vehicleAssembler.getTotalPrice();
//    }
//
//    @Override
//    public long getTotalAttack() {
//        return this.vehicleAssembler.getTotalAttackModification();
//    }
//
//    @Override
//    public long getTotalDefense() {
//        return this.vehicleAssembler.getTotalDefenseModification();
//    }
//
//    @Override
//    public long getTotalHitPoints() {
//        return this.vehicleAssembler.getTotalHitPointModification();
//    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Revenger - %s%n",super.getModel()));
        builder.append(String.format("Total Weight: %.3f%n",super.getTotalWeight()));
        builder.append(String.format("Total Price: %.3f%n",super.getTotalPrice()));
        builder.append(String.format("Attack: %d%n",super.getTotalAttack()));
        builder.append(String.format("Defense: %d%n",super.getTotalDefense()));
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

        if (allParts.isEmpty()){
            builder.append("None");
        }
        else{
            builder.append(String.join(", ",allParts));
        }

        return builder.toString();
    }
}
