package FifthExersiceReflection.pr0304Barracks.core.commands;

import FifthExersiceReflection.pr0304Barracks.annotations.Inject;
import FifthExersiceReflection.pr0304Barracks.contracts.Executable;
import FifthExersiceReflection.pr0304Barracks.contracts.Repository;
import FifthExersiceReflection.pr0304Barracks.contracts.UnitFactory;

public abstract class Command implements Executable {
    @Inject
    private String[] data;
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    protected Command() {
    }

    protected String[] getData() {
        return this.data;
    }

    protected Repository getRepository() {
        return this.repository;
    }

    protected UnitFactory getUnitFactory() {
        return this.unitFactory;
    }
}
