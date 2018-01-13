package blobsMine.core.commands;

import blobsMine.core.BaseCommand;
import blobsMine.interfaces.Blob;

public class AttackCommand extends BaseCommand {

    @Override
    public String execute() {
        Blob attacker = super.getRepository().findByName(super.getParams().get(1));
        Blob target = super.getRepository().findByName(super.getParams().get(2));

        attacker.attack(target);

        if (attacker.getHealth() / 2 <= attacker.getInitialHealth()){
            attacker.triggerBehavior();
        }
        if (target.getHealth() / 2 <= target.getInitialHealth()){
            target.triggerBehavior();
        }

        return null;
    }
}
