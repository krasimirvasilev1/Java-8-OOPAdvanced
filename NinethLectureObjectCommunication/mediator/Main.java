package NinethLectureObjectCommunication.mediator;

import NinethLectureObjectCommunication.mediator.commands.Group;
import NinethLectureObjectCommunication.mediator.commands.GroupAttackCommand;
import NinethLectureObjectCommunication.mediator.commands.GroupTargetCommand;
import NinethLectureObjectCommunication.mediator.interfaces.AttackGroup;
import NinethLectureObjectCommunication.mediator.interfaces.Attacker;
import NinethLectureObjectCommunication.mediator.interfaces.Command;
import NinethLectureObjectCommunication.mediator.interfaces.Target;
import NinethLectureObjectCommunication.mediator.models.hero.Dragon;
import NinethLectureObjectCommunication.mediator.models.hero.Warrior;
import NinethLectureObjectCommunication.mediator.models.logger.CombatLogger;
import NinethLectureObjectCommunication.mediator.models.logger.EventLogger;
import NinethLectureObjectCommunication.mediator.models.logger.Logger;

public class Main {
    public static void main(String[] args) {
        Logger combatLogger = new CombatLogger();
        Logger eventLogger = new EventLogger();

        combatLogger.setSuccessor(eventLogger);

        AttackGroup attackGroup = new Group();
        Attacker firstAttacker = new Warrior("Pesho",20);
        Attacker secondAttacker = new Warrior("Goshko",40);

        Target target = new Dragon("Chiki",20,50);

        attackGroup.addMember(firstAttacker);
        attackGroup.addMember(secondAttacker);

        Command groupTarget = new GroupTargetCommand(attackGroup,target);
        Command attackTarget = new GroupAttackCommand(attackGroup);

        groupTarget.execute();
        attackTarget.execute();
    }
}
