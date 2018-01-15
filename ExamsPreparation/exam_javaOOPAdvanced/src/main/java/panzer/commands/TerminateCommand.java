package panzer.commands;

public class TerminateCommand extends BaseCommand {

    @Override
    public void execute() throws IllegalAccessException, NoSuchFieldException {
        System.out.println(this.getBattlefield().terminate(getParams()));
    }
}
