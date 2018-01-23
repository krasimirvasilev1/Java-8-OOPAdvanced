package NinethExersiceObjectCommunicationAndEvents.kings_gambit.commands;

import NinethExersiceObjectCommunicationAndEvents.kings_gambit.interfaces.King;

public class CommandController {

    public static String commandDispatcher(String[] commands, King king) {
        switch (commands[0]) {
            case "Kill":
                king.killGuardOrFootman(commands[1]);
                return null;
            case "Attack":
                king.kingIsUnderAttack();
                return null;
                default:
                    return "End";
        }
    }
}
