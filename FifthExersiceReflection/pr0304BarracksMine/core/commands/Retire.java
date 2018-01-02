package FifthExersiceReflection.pr0304BarracksMine.core.commands;

import java.lang.reflect.InvocationTargetException;

public class Retire extends Command {

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        String unitType = getData()[1];
        return this.getRepository().removeUnit(unitType);
    }
}
