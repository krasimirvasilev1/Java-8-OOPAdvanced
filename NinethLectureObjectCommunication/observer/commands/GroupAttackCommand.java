package NinethLectureObjectCommunication.observer.commands;

import NinethLectureObjectCommunication.observer.interfaces.AttackGroup;
import NinethLectureObjectCommunication.observer.interfaces.Command;

public class GroupAttackCommand implements Command{
    private AttackGroup attackGroup;

    public GroupAttackCommand(AttackGroup attackGroup) {
        this.attackGroup = attackGroup;
    }


    @Override
    public void execute() {
        this.attackGroup.groupAttack();
    }
}
