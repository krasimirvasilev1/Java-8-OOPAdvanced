package NinethLectureObjectCommunication.observer.commands;

import NinethLectureObjectCommunication.observer.interfaces.AttackGroup;
import NinethLectureObjectCommunication.observer.interfaces.Command;
import NinethLectureObjectCommunication.observer.interfaces.Target;


public class GroupTargetCommand implements Command{
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
