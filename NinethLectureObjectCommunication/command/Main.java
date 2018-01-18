package NinethLectureObjectCommunication.command;

import NinethLectureObjectCommunication.command.interfaces.Attacker;
import NinethLectureObjectCommunication.command.interfaces.Command;
import NinethLectureObjectCommunication.command.interfaces.Executor;
import NinethLectureObjectCommunication.command.interfaces.Target;
import NinethLectureObjectCommunication.command.models.*;
import NinethLectureObjectCommunication.command.models.commands.AttackCommand;
import NinethLectureObjectCommunication.command.models.commands.TargetCommand;

public class Main {
    public static void main(String[] args) {
        Logger combatLogger = new CombatLogger();
        Logger tagetLogger = new TargetLogger();

        combatLogger.setSuccessor(tagetLogger);

        Attacker warrior = new Warrior("Warrior",10,combatLogger);
        Target dragon = new Dragon("Dragon",100,25,combatLogger);

        Executor executor = new CommandExecutor();
        Command setTarget = new TargetCommand(warrior,dragon);
        Command attackCommand = new AttackCommand(warrior);

        executor.executeCommand(setTarget);
        executor.executeCommand(attackCommand);
    }
}
