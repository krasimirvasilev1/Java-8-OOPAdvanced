package FifthExersiceReflection.pr0304Barracks.interpreters;

import FifthExersiceReflection.pr0304Barracks.contracts.CommandInterpreter;
import FifthExersiceReflection.pr0304Barracks.contracts.Executable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {
    private static final String COMMANDS_PACKAGE_NAME =
            "FifthExersiceReflection.pr0304Barracks.core.commands.";
    private static final String COMMAND_SUFFIX = "NinethLectureObjectCommunication/command";

    @Override
    public Executable interpretCommand(String commandName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String correctCommandName = String.valueOf(commandName.charAt(0)).toUpperCase() + commandName.substring(1);
        Class<?> commandClass;
        try {
            commandClass = Class.forName(COMMANDS_PACKAGE_NAME + correctCommandName + COMMAND_SUFFIX);
        } catch (ClassNotFoundException cnfe) {
            throw new RuntimeException("Invalid commands!");
        }

        Constructor<?> constructor = commandClass.getDeclaredConstructor();
        Executable command = (Executable) constructor.newInstance();
        return command;
    }
}
