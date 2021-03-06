package FifthExersiceReflection.pr0304Barracks.core.commands;

import FifthExersiceReflection.pr0304Barracks.contracts.Unit;

import java.lang.reflect.InvocationTargetException;

public class AddCommand extends Command {

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String unitType = super.getData()[1];
        Unit unitToAdd = super.getUnitFactory().createUnit(unitType);
        super.getRepository().addUnit(unitToAdd);
        String output = unitType + " added!";
        return output;
    }
}
