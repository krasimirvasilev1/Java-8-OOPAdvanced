package panzer.commands;

public class InspectCommand extends BaseCommand {

    @Override
    public void execute() throws IllegalAccessException, NoSuchFieldException {
        System.out.println(super.getBattlefield().inspect(super.getParams()));
    }
}
