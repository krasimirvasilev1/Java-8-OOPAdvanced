package NinethLectureObjectCommunication.mediator;

import NinethLectureObjectCommunication.mediator.interfaces.Command;
import NinethLectureObjectCommunication.mediator.interfaces.Executor;

public class CommandExecutor implements Executor {

    @Override
    public void executeCommand(Command command) {
        command.execute();
    }
}
