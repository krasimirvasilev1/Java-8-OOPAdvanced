package cresla.entities.models.modules;


public class CryogenRod extends AbstractEnergyOutput {

    public CryogenRod(int id, int energyOutput) {
        super(id, energyOutput);
    }


    @Override
    public String toString() {
        return String.format("CryogenRod Module - %d%nEnergy Output: %d",super.getId(),this.getEnergyOutput());
    }
}
