package cresla.entities.models.modules;

import cresla.interfaces.EnergyModule;

public abstract class AbstractEnergyOutput extends ModuleImpl implements EnergyModule {
    private int energyOutput;

    protected AbstractEnergyOutput(int id, int energyOutput) {
        super(id);
        this.energyOutput = energyOutput;
    }

    @Override
    public int getEnergyOutput() {
        return this.energyOutput;
    }
}
