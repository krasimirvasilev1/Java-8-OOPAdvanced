package NinethLectureObjectCommunication.observer;

import NinethLectureObjectCommunication.observer.commands.Group;
import NinethLectureObjectCommunication.observer.commands.GroupAttackCommand;
import NinethLectureObjectCommunication.observer.commands.GroupTargetCommand;
import NinethLectureObjectCommunication.observer.interfaces.*;
import NinethLectureObjectCommunication.observer.models.hero.AbstractHero;
import NinethLectureObjectCommunication.observer.models.hero.Dragon;
import NinethLectureObjectCommunication.observer.models.hero.Warrior;
import NinethLectureObjectCommunication.observer.models.logger.CombatLogger;
import NinethLectureObjectCommunication.observer.models.logger.EventLogger;
import NinethLectureObjectCommunication.observer.models.logger.Logger;

public class Main {
    public static void main(String[] args) {
        Logger combatLogger = new CombatLogger();
        Logger eventLogger = new EventLogger();

        combatLogger.setSuccessor(eventLogger);

        AbstractHero firstAttacker = new Warrior("Pesho",20,combatLogger);
        AbstractHero secondAttacker = new Warrior("Goshko",40,combatLogger);

        Dragon target = new Dragon("Chiki",20,50);

        AttackGroup attackGroup = new Group();
        attackGroup.addMember(firstAttacker);
        attackGroup.addMember(secondAttacker);

        target.register(firstAttacker);
        target.register(secondAttacker);

        CommandExecutor executor = new CommandExecutor();
        Command groupTarget = new GroupTargetCommand(attackGroup,target);
        Command attackTarget = new GroupAttackCommand(attackGroup);

        executor.executeCommand(groupTarget);
        executor.executeCommand(attackTarget);
    }
}
