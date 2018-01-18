package NinethLectureObjectCommunication.logger.models;

import NinethLectureObjectCommunication.logger.interfaces.Command;
import NinethLectureObjectCommunication.logger.interfaces.Executor;

public class CommandExecutor implements Executor {

    @Override
    public void executeCommand(Command command) {
        command.execute();
    }
}
