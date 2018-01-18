package NinethLectureObjectCommunication.command.interfaces;

import NinethLectureObjectCommunication.command.enums.LogType;

public interface Handler {

    void handle(LogType type, String message);

    void setSuccessor(Handler handler);
}
