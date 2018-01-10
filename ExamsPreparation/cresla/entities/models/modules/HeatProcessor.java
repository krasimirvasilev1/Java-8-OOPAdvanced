package cresla.entities.models.modules;


public class HeatProcessor extends AbstractHeatAbsorbing {

    public HeatProcessor(int id, int heatAbsorbing) {
        super(id, heatAbsorbing);
    }

    @Override
    public String toString() {
        return String.format("HeatProcessor Module - %d%nHeat Absorbing: %d",super.getId(),getHeatAbsorbing());
    }
}
