package NinethLectureObjectCommunication.mediator.models.logger;

import NinethLectureObjectCommunication.mediator.enums.LogType;

public class CombatLogger extends Logger {

    @Override
    public void handle(LogType type, String message) {
        if (LogType.ATTACK == type || LogType.MAGIC == type) {
            System.out.println(type + ": " + message);
        } else {
            super.passToSuccessor(type,message);
        }
    }
}
