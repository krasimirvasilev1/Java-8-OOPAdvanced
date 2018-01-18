package NinethLectureObjectCommunication.command.models;

import NinethLectureObjectCommunication.command.enums.LogType;
import NinethLectureObjectCommunication.command.interfaces.Handler;
import NinethLectureObjectCommunication.command.interfaces.Target;

public class Warrior extends AbstractHero {

    private static final String ATTACK_MESSAGE = "%s damages %s for %s";

    public Warrior(String id, int dmg, Handler handler) {
        super(id, dmg, handler);
    }

    @Override
    protected void executeClassSpecificAttack(Target target, int dmg) {
        super.getHandler().handle(LogType.ATTACK,String.format(ATTACK_MESSAGE, this, target, dmg));
        target.receiveDamage(dmg);
    }

    public int getAttackDamage() {
        return 0;
    }
}
