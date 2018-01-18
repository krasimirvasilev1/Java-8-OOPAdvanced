package NinethLectureObjectCommunication.command.models;

import NinethLectureObjectCommunication.command.enums.LogType;

public class EventLogger extends Logger {

    @Override
    public void handle(LogType type, String message) {
        if (LogType.EVENT == type){
            System.out.println(type + ": " + message);
        }
        else{
            super.passToSuccessor(type,message);
        }
    }
}
