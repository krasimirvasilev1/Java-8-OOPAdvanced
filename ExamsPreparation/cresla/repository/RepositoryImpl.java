package cresla.repository;

import cresla.interfaces.Identifiable;
import cresla.interfaces.Module;
import cresla.interfaces.Reactor;

import java.util.LinkedHashMap;
import java.util.Map;

public class RepositoryImpl implements Repository {
    private Map<Integer, Reactor> allReactors;
    private Map<Integer, Identifiable> reactorsAndModuls;
    private int energyModulesCounter;
    private int absorbingModulesCounter;
    private int cryoReactorCounter;
    private int heatReactorCounter;

    public RepositoryImpl() {

        this.allReactors = new LinkedHashMap<>();
        this.reactorsAndModuls = new LinkedHashMap<>();
        this.energyModulesCounter = 0;
        this.absorbingModulesCounter = 0;
        this.cryoReactorCounter = 0;
        this.heatReactorCounter = 0;
    }

    @Override
    public int getEnergyModulesCounter() {
        return this.energyModulesCounter;
    }

    @Override
    public int getAbsorbingModulesCounter() {
        return this.absorbingModulesCounter;
    }

    @Override
    public int getCryoReactorCounter() {
        return this.cryoReactorCounter;
    }

    @Override
    public int getHeatReactorCounter() {
        return this.heatReactorCounter;
    }

    @Override
    public Map<Integer, Reactor> getAllReactors() {
        return this.allReactors;
    }

    @Override
    public Map<Integer, Identifiable> getReactorsAndModuls() {
        return this.reactorsAndModuls;
    }

    @Override
    public void increaseEnergyModulesCounter() {
        this.energyModulesCounter++;
    }

    @Override
    public void increaseAbsorbingModulesCounter() {
        this.absorbingModulesCounter++;
    }

    @Override
    public void increaseCryoReactorCounter() {
        this.cryoReactorCounter++;
    }

    @Override
    public void increaseHeatReactorCounter() {
        this.heatReactorCounter++;
    }

    @Override
    public void addModule(int idCounter, Identifiable module) {
        this.reactorsAndModuls.put(idCounter,module);
    }

    @Override
    public void addReactor(int idCounter , Reactor reactor) {
        this.allReactors.put(idCounter, reactor);
        this.reactorsAndModuls.put(idCounter, reactor);
    }

    @Override
    public long getReactorsTotalEnergyOutput(){
       return this.allReactors.entrySet().stream().mapToLong(x -> x.getValue().getTotalEnergyOutput()).sum();
    }

    @Override
    public long getReactorsTotalHeatAbsorbing(){
        return this.allReactors.entrySet().stream().mapToLong(x -> x.getValue().getTotalHeatAbsorbing()).sum();
    }
}
