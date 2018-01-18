package NinethLectureObjectCommunication.command.models.commands;

import NinethLectureObjectCommunication.command.interfaces.Attacker;
import NinethLectureObjectCommunication.command.interfaces.Command;
import NinethLectureObjectCommunication.command.interfaces.Target;

public class TargetCommand implements Command {

    private Attacker attacker;
    private Target target;

    public TargetCommand(Attacker attacker) {
        this.attacker = attacker;
    }

    public TargetCommand(Attacker attacker, Target target){
        this.attacker = attacker;
        this.target = target;
    }

    @Override
    public void execute() {
        this.attacker.setTarget(target);
    }
}
