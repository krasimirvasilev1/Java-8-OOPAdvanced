package blobsMine.core;

import blobsMine.annotations.Inject;
import blobsMine.repository.Repository;
import blobsMine.interfaces.Blob;
import blobsMine.interfaces.Executable;
import java.util.List;

public abstract class BaseCommand implements Executable {
    @Inject
    private Repository<Blob> repository;

    @Inject
    private List<String> params;

    public BaseCommand() {
    }

    public Repository<Blob> getRepository() {
        return this.repository;
    }

    public List<String> getParams() {
        return this.params;
    }
}
