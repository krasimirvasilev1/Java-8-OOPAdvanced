package NinethLectureObjectCommunication.logger.commands;

import NinethLectureObjectCommunication.logger.interfaces.Attacker;
import NinethLectureObjectCommunication.logger.interfaces.Command;
import NinethLectureObjectCommunication.logger.interfaces.Target;

public class TargetCommand implements Command{

    private Attacker attacker;
    private Target target;

    public TargetCommand(Attacker attacker, Target target) {
        this.attacker = attacker;
        this.target = target;
    }

    @Override
    public void execute() {
        this.attacker.setTarget(this.target);
    }
}
