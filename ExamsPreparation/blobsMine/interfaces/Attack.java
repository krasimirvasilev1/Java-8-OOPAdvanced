package blobsMine.interfaces;

import blobsMine.models.BlobImpl;

public interface Attack {
    void execute(Blob attacker, Blob target);
}
