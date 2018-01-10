package cresla.commands;

import cresla.annotations.Inject;
import cresla.interfaces.Executable;
import cresla.repository.Repository;

import java.util.List;

public abstract class Command implements Executable{

    @Inject
    private int idCounter;

    @Inject
    private List<String> commands;

    @Inject
    private Repository repository;

    public List<String> getCommands() {
        return this.commands;
    }

    public Repository getRepository() {
        return this.repository;
    }

    public int getIdCounter() {
        return this.idCounter;
    }
}
