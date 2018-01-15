package panzer.models.parts;

import panzer.contracts.DefenseModifyingPart;
import panzer.contracts.HitPointsModifyingPart;

import java.math.BigDecimal;

public class EndurancePart extends Parts implements HitPointsModifyingPart{
    private int hitPointsModifier;

    public EndurancePart(String model, double weight, BigDecimal price, int hitPointsModifier) {
        super(model, weight, price);
        this.hitPointsModifier = hitPointsModifier;
    }


    @Override
    public int getHitPointsModifier() {
        return this.hitPointsModifier;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Endurance Part - %s%n",super.getModel()));
        builder.append(String.format("+HitPoints %d", this.hitPointsModifier));

        return builder.toString();
    }
}
