package FifthExersiceReflection.pr0304BarracksMine.core.commands;

import java.lang.reflect.InvocationTargetException;

public class Report extends Command{


    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String output = this.getRepository().getStatistics();
        return output;
    }
}
