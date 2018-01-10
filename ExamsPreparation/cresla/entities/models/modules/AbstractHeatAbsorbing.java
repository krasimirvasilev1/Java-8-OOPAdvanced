package cresla.entities.models.modules;

import cresla.interfaces.AbsorbingModule;

public abstract class AbstractHeatAbsorbing extends ModuleImpl implements AbsorbingModule {
    private int heatAbsorbing;

    protected AbstractHeatAbsorbing(int id, int heatAbsorbing) {
        super(id);
        this.heatAbsorbing = heatAbsorbing;
    }

    @Override
    public int getHeatAbsorbing() {
        return this.heatAbsorbing;
    }
}

