package FifthExersiceReflection.pr0304BarracksMine.core.commands;

import java.lang.reflect.InvocationTargetException;

public class Fight extends Command {

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return "fight";
    }
}
