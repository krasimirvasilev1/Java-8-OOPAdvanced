package NinethLectureObjectCommunication.mediator.commands;

import NinethLectureObjectCommunication.mediator.interfaces.AttackGroup;
import NinethLectureObjectCommunication.mediator.interfaces.Command;
import NinethLectureObjectCommunication.mediator.interfaces.Target;


public class GroupTargetCommand implements Command {
    private AttackGroup attackGroup;
    private Target target;

    public GroupTargetCommand(AttackGroup attackGroup, Target target) {
        this.attackGroup = attackGroup;
        this.target = target;
    }


    @Override
    public void execute() {
        this.attackGroup.groupTarget(this.target);
    }
}
