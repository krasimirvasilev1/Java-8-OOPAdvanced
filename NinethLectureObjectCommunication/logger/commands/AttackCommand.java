package NinethLectureObjectCommunication.logger.commands;

import NinethLectureObjectCommunication.logger.interfaces.Attacker;
import NinethLectureObjectCommunication.logger.interfaces.Command;

public class AttackCommand implements Command{

    private Attacker attacker;

    public AttackCommand(Attacker attacker) {
        this.attacker = attacker;
    }


    @Override
    public void execute() {
    }
}
