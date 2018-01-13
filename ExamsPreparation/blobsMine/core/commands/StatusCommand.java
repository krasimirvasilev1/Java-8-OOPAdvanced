package blobsMine.core.commands;

import blobsMine.core.BaseCommand;
import blobsMine.interfaces.Blob;

public class StatusCommand extends BaseCommand {
    private static final String AGGRESSIVE_BEHAVIOR_TYPE = "Aggressive";
    private static final String BLOBPLODE_ATTACK_TYPE = "Blobplode";

    @Override
    public String execute() {
        StringBuilder builder = new StringBuilder();
        for (Blob blob : super.getRepository().findAll().values()) {
            builder.append("Blob "+ blob.getName()+": "+blob.getHealth()+" HP, "+ blob.getDamage()+" Damage");
            builder.append(System.lineSeparator());
        }

        return builder.toString();
    }
}
