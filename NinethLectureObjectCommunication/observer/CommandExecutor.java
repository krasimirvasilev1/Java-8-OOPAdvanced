package NinethLectureObjectCommunication.observer;

import NinethLectureObjectCommunication.observer.interfaces.Command;
import NinethLectureObjectCommunication.observer.interfaces.Executor;

public class CommandExecutor implements Executor {

    @Override
    public void executeCommand(Command command) {
        command.execute();
    }
}
