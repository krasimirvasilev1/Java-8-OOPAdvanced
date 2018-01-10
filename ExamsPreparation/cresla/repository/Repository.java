package cresla.repository;

import cresla.interfaces.Identifiable;
import cresla.interfaces.Module;
import cresla.interfaces.Reactor;

import java.util.Map;

public interface Repository {

    void addReactor(int idCounter, Reactor reactor);

    Map<Integer, Reactor> getAllReactors();

    void addModule(int idCounter, Identifiable module);

    Map<Integer, Identifiable> getReactorsAndModuls();

    void increaseEnergyModulesCounter();

    void increaseAbsorbingModulesCounter();

    void increaseCryoReactorCounter();

    void increaseHeatReactorCounter();

    int getEnergyModulesCounter();

    int getAbsorbingModulesCounter();

    int getCryoReactorCounter();

    int getHeatReactorCounter();

    long getReactorsTotalEnergyOutput();

    long getReactorsTotalHeatAbsorbing();
}
