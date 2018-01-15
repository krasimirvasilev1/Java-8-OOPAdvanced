package panzer.commands;

public class VehicleCommand extends BaseCommand {
    @Override
    public void execute() throws IllegalAccessException {
        System.out.println(super.getBattlefield().addVehicle(super.getParams()));
    }
}
