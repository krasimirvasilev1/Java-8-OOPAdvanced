package blobsMine.core.commands;

import blobsMine.interfaces.Blob;
import blobsMine.models.BlobImpl;
import blobsMine.models.attacks.Blobplode;
import blobsMine.core.BaseCommand;
import blobsMine.interfaces.Attack;
import blobsMine.interfaces.Behavior;
import blobsMine.models.attacks.PutridFart;
import blobsMine.models.behavors.Aggressive;
import blobsMine.models.behavors.Inflated;

public class CreateCommand extends BaseCommand {
    private static final String AGGRESSIVE_BEHAVIOR_TYPE = "Aggressive";
    private static final String BLOBPLODE_ATTACK_TYPE = "Blobplode";

    @Override
    public String execute() {
        Behavior behavior = null;
        Attack attack = null;
        if (super.getParams().get(4).equalsIgnoreCase(AGGRESSIVE_BEHAVIOR_TYPE)){
            behavior = new Aggressive();
        }
        else {
            behavior = new Inflated();
        }
        if (super.getParams().get(5).equalsIgnoreCase(BLOBPLODE_ATTACK_TYPE)){
            attack = new Blobplode();
        }
        else {
            attack = new PutridFart();
        }
        Blob blob = new BlobImpl(super.getParams().get(1),Integer.parseInt(super.getParams().get(2)),Integer.parseInt(super.getParams().get(3)),behavior,attack);
        super.getRepository().add(blob);

        return null;
    }
}
