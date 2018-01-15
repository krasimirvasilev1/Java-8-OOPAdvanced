package panzer.commands;

public class PartCommand extends BaseCommand {

    @Override
    public void execute() throws IllegalAccessException {
        System.out.println(super.getBattlefield().addPart(super.getParams()));
    }
}
