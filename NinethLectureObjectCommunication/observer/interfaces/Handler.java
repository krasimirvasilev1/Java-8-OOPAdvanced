package NinethLectureObjectCommunication.observer.interfaces;

import NinethLectureObjectCommunication.observer.enums.LogType;

public interface Handler {

    void handle(LogType type, String message);

    void setSuccessor(Handler handler);
}
