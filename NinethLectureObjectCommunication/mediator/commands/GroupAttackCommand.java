package NinethLectureObjectCommunication.mediator.commands;

import NinethLectureObjectCommunication.mediator.interfaces.AttackGroup;
import NinethLectureObjectCommunication.mediator.interfaces.Command;

public class GroupAttackCommand implements Command {
    private AttackGroup attackGroup;

    public GroupAttackCommand(AttackGroup attackGroup) {
        this.attackGroup = attackGroup;
    }


    @Override
    public void execute() {
        this.attackGroup.groupAttack();
    }
}
