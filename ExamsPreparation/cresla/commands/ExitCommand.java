package cresla.commands;

public class ExitCommand extends Command {

    @Override
    public String execute() {

        return String.format("Cryo Reactors: %d%nHeat Reactors: %d%nEnergy Modules: %d%n" +
                        "Absorbing Modules: %d%nTotal Energy Output: %d%nTotal Heat Absorbing: %d",
                super.getRepository().getCryoReactorCounter(),super.getRepository().getHeatReactorCounter(),
                super.getRepository().getEnergyModulesCounter(),super.getRepository().getAbsorbingModulesCounter(),
                super.getRepository().getReactorsTotalEnergyOutput(),super.getRepository().getReactorsTotalHeatAbsorbing());
    }
}
