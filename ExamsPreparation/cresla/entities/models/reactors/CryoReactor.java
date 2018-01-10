package cresla.entities.models.reactors;

public class CryoReactor extends ReactorImpl {

    private int cryoProductionIndex;

    public CryoReactor(int id, int cryoProductionIndex,int moduleCapacity) {
        super(id , moduleCapacity);
        this.cryoProductionIndex = cryoProductionIndex;
    }


    @Override
    public long getTotalEnergyOutput() {
        long totalEnergyOutput = super.getContainer().getTotalEnergyOutput() *  this.cryoProductionIndex;

        if (totalEnergyOutput > this.getTotalHeatAbsorbing()){
            totalEnergyOutput = 0;
        }

        return totalEnergyOutput;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return  super.getContainer().getTotalHeatAbsorbing();
    }

    @Override
    public String toString() {
        return String.format("CryoReactor - %d%nEnergy Output: %d%nHeat Absorbing: %d%nModules: %d",getId(),getTotalEnergyOutput(),getTotalHeatAbsorbing(),super.getModuleCount());
    }
}
