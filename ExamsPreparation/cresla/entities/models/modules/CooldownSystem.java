package cresla.entities.models.modules;


public class CooldownSystem extends AbstractHeatAbsorbing {

    public CooldownSystem(int id, int heatAbsorbing) {
        super(id, heatAbsorbing);
    }

    @Override
    public String toString() {
        return String.format("CooldownSystem Module - %d%nHeat Absorbing: %d",super.getId(),this.getHeatAbsorbing());
    }
}
