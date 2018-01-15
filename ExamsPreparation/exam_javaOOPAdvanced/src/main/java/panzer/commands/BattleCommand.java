package panzer.commands;

public class BattleCommand extends BaseCommand {

    @Override
    public void execute() throws IllegalAccessException {
        System.out.println(super.getBattlefield().battle(super.getParams()));
    }
}
