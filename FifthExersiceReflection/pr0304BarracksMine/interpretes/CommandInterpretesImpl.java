package FifthExersiceReflection.pr0304BarracksMine.interpretes;

import FifthExersiceReflection.pr0304BarracksMine.contracts.CommandInterpreter;
import FifthExersiceReflection.pr0304BarracksMine.contracts.Executable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpretesImpl implements CommandInterpreter {
    private static final String UNITS_PACKAGE_NAME =
            "FifthExersiceReflection.pr0304BarracksMine.core.commands.";

    @Override
    public Executable interpretCommand(String commandName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class <?> newClass = null;
        try {
            newClass = Class.forName(UNITS_PACKAGE_NAME + commandName.toUpperCase().charAt(0) + commandName.substring(1));
        }catch (ClassNotFoundException cnfe){
            throw new RuntimeException("Invalid commands!");
        }
        Constructor<?> constructor = newClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        Executable newObject = (Executable) constructor.newInstance();
        return newObject;
    }
}
