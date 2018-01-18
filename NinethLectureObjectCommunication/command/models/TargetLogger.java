package NinethLectureObjectCommunication.command.models;

import NinethLectureObjectCommunication.command.enums.LogType;

public class TargetLogger extends Logger {

    @Override
    public void handle(LogType type, String message) {
        if (LogType.TARGET == type){
            System.out.println(type + ": " + message);
        }
        else{
            super.passToSuccessor(type,message);
        }
    }
}
