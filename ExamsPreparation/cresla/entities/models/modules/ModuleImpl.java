package cresla.entities.models.modules;

import cresla.interfaces.Module;

public abstract class ModuleImpl implements Module {
    private int id;

    protected ModuleImpl(int id) {
        this.id = id;
    }

    @Override
    public int getId(){
        return this.id;
    }
}
