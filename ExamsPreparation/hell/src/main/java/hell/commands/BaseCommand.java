package hell.commands;

import hell.annotations.Inject;
import hell.interfaces.Executable;
import hell.repository.Repository;

import java.util.List;

public abstract class BaseCommand implements Executable{

    @Inject
    private List<String> params;

    @Inject
    private Repository repository;

    protected BaseCommand() {}

    public List<String> getParams() {
        return this.params;
    }

    public Repository getRepository() {
        return this.repository;
    }
}
