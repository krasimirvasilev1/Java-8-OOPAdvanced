package FifthExersiceReflection.pr0304BarracksMine.core.commands;

import FifthExersiceReflection.pr0304BarracksMine.contracts.Unit;

import java.lang.reflect.InvocationTargetException;

public class Add extends Command {

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String unitType = getData()[1];
        Unit unitToAdd = this.getUnitFactory().createUnit(unitType);
        this.getRepository().addUnit(unitToAdd);
        String output = unitType + " added!";
        return output;
    }
}
