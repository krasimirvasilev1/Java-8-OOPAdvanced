package NinethLectureObjectCommunication.observer.models.hero;

import NinethLectureObjectCommunication.observer.interfaces.Attacker;
import NinethLectureObjectCommunication.observer.interfaces.Handler;
import NinethLectureObjectCommunication.observer.interfaces.Observer;
import NinethLectureObjectCommunication.observer.interfaces.Target;

public abstract class AbstractHero implements Attacker,Observer {

    private static final String TARGET_NULL_MESSAGE = "Target null";
    private static final String NO_TARGET_MESSAGE = "%s has no target";
    private static final String TARGET_DEAD_MESSAGE = "%s is dead";
    private static final String SET_TARGET_MESSAGE = "%s targets %s";

    private String id;
    private int dmg;
    private Handler handler;
    private Target target;

    public AbstractHero(String id, int dmg, Handler handler) {
        this.id = id;
        this.dmg = dmg;
        this.handler = handler;
    }

    public String getId() {
        return this.id;
    }

    public Handler getHandler() {
        return this.handler;
    }

    public void setTarget(Target target) {
        if (target == null) {
            System.out.println(TARGET_NULL_MESSAGE);
        } else {
            this.target = target;
            System.out.println(String.format(SET_TARGET_MESSAGE, this, target));
        }
    }

    public final void attack() {
        if (this.target == null) {
            System.out.println(String.format(NO_TARGET_MESSAGE, this));
        } else if (this.target.isDead()) {
            System.out.println(String.format(TARGET_DEAD_MESSAGE, target));
        } else {
            this.executeClassSpecificAttack(this.target, this.dmg);
        }
    }

    @Override
    public String toString() {
        return this.id;
    }

    protected abstract void executeClassSpecificAttack(Target target, int dmg);
}
