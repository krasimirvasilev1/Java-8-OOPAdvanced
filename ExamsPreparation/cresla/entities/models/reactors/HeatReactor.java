package cresla.entities.models.reactors;


public class HeatReactor extends ReactorImpl {
    private int heatReductionIndex;

    public HeatReactor(int id, int heatReductionIndex, int moduleCapacity) {
        super(id, moduleCapacity);
        this.heatReductionIndex = heatReductionIndex;
    }

    @Override
    public long getTotalEnergyOutput() {
        long totalEnergyOutput = super.getContainer().getTotalEnergyOutput();

        if (totalEnergyOutput > this.getTotalHeatAbsorbing()){
            totalEnergyOutput = 0;
        }

        return totalEnergyOutput;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return super.getContainer().getTotalHeatAbsorbing() + this.heatReductionIndex;
    }

    @Override
    public String toString() {
        return String.format("HeatReactor - %d%nEnergy Output: %d%nHeat Absorbing: %d%nModules: %d",getId(),getTotalEnergyOutput(),getTotalHeatAbsorbing(),super.getModuleCount());
    }
}
