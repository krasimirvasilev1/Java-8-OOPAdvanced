package cresla.commands;

import cresla.entities.models.reactors.CryoReactor;
import cresla.entities.models.reactors.HeatReactor;
import cresla.interfaces.Reactor;

public class ReactorCommand extends Command {


    @Override
    public String execute() {
        Reactor reactor;
        int idNumber = super.getRepository().getReactorsAndModuls().size() + super.getIdCounter();
        if (getCommands().get(1).equalsIgnoreCase("Cryo")){
            reactor = new CryoReactor(idNumber,Integer.parseInt(getCommands().get(2)),Integer.parseInt(getCommands().get(3)));
            super.getRepository().increaseCryoReactorCounter();
        }
        else {
            reactor = new HeatReactor(idNumber,Integer.parseInt(getCommands().get(2)),Integer.parseInt(getCommands().get(3)));
            super.getRepository().increaseHeatReactorCounter();
        }
        super.getRepository().addReactor(idNumber,reactor);

        return String.format("Created %s Reactor - %d",getCommands().get(1),idNumber);
    }
}
