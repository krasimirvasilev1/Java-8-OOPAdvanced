package cresla.entities.models.reactors;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.*;

import java.lang.reflect.Field;
import java.util.LinkedList;

public abstract class ReactorImpl implements Reactor {
    private int id;
    private Container container;

    protected ReactorImpl(int id ,int moduleCapacity) {
        this.id = id;
        this.container = new ModuleContainer(moduleCapacity);
    }

    @Override
    public int getId(){
        return this.id;
    }

    protected Container getContainer() {
        return this.container;
    }

    @Override
    public abstract long getTotalEnergyOutput();

    @Override
    public abstract long getTotalHeatAbsorbing();
    @Override
    @SuppressWarnings("unchecked")
    public int getModuleCount() {
        Class moduleContainer = getContainer().getClass();
        Field field = moduleContainer.getDeclaredFields()[1];
        field.setAccessible(true);
        int moduleCount = 0;
        try {
            moduleCount = ((LinkedList<Module>)field.get(getContainer())).size();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return moduleCount;
    }

    @Override
    public void addEnergyModule(EnergyModule energyModule) {
        getContainer().addEnergyModule(energyModule);
    }

    @Override
    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
        getContainer().addAbsorbingModule(absorbingModule);
    }
}
