package NinethLectureObjectCommunication.mediator.interfaces;

import NinethLectureObjectCommunication.mediator.enums.LogType;

public interface Handler {

    void handle(LogType type, String message);

    void setSuccessor(Handler handler);
}
