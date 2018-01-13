package blobsMine.models.attacks;

import blobsMine.interfaces.Blob;

public class Blobplode extends AbstractAttack {

    @Override
    public void execute(Blob source, Blob target) {
        source.setHealth(source.getHealth() / 2);
        target.respond(source.getDamage() * 2);
    }
}
