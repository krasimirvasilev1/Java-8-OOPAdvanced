package NinethLectureObjectCommunication.logger;

import NinethLectureObjectCommunication.logger.interfaces.Attacker;
import NinethLectureObjectCommunication.logger.interfaces.Target;
import NinethLectureObjectCommunication.logger.models.*;

public class Main {
    public static void main(String[] args) {

        Logger logger  = new CombatLogger();
        Logger otherLogger = new EventLogger();

        logger.setSuccessor(otherLogger);

        Attacker attacker = new Warrior("Peshi",10,logger);
        Target target = new Dragon("Niki",8,20,logger);

        attacker.setTarget(target);
        attacker.attack();
    }
}
