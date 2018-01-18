package NinethLectureObjectCommunication.command.models;

import NinethLectureObjectCommunication.command.interfaces.Command;
import NinethLectureObjectCommunication.command.interfaces.Executor;

public class CommandExecutor implements Executor {

    @Override
    public void executeCommand(Command command) {
        command.execute();
    }
}
