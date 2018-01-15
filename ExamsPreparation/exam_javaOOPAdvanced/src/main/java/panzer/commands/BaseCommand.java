package panzer.commands;

import panzer.annotations.Inject;
import panzer.contracts.Executable;
import panzer.contracts.Manager;

import java.util.Collections;
import java.util.List;

public abstract class BaseCommand implements Executable{

    @Inject
    private List<String> params;
    @Inject
    private Manager battlefield;

    protected BaseCommand() {
    }

    protected List<String> getParams() {
        return Collections.unmodifiableList(this.params);
    }

    protected Manager getBattlefield() {
        return this.battlefield;
    }
}
