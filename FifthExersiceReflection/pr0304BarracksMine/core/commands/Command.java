package FifthExersiceReflection.pr0304BarracksMine.core.commands;

import FifthExersiceReflection.pr0304BarracksMine.annotations.Inject;
import FifthExersiceReflection.pr0304BarracksMine.contracts.Executable;
import FifthExersiceReflection.pr0304BarracksMine.contracts.Repository;
import FifthExersiceReflection.pr0304BarracksMine.contracts.UnitFactory;

public abstract class Command implements Executable {
    private static final String UNITS_PACKAGE_NAME =
            "FifthExersiceReflection.pr0304BarracksMine.core.commands.";

    @Inject
    private String[] data;
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    protected String[] getData() {
        return this.data;
    }

    protected Repository getRepository() {
        return this.repository;
    }

    protected UnitFactory getUnitFactory() {
        return this.unitFactory;
    }

    protected Command(){
    }
}
