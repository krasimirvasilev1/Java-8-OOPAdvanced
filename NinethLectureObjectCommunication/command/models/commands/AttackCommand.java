package NinethLectureObjectCommunication.command.models.commands;

import NinethLectureObjectCommunication.command.interfaces.Attacker;
import NinethLectureObjectCommunication.command.interfaces.Command;

public class AttackCommand implements Command {

    private Attacker attacker;

    public AttackCommand(Attacker attacker) {
        this.attacker = attacker;
    }

    @Override
    public void execute() {
        this.attacker.attack();
    }
}
