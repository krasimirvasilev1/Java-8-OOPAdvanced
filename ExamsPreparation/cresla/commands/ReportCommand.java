package cresla.commands;

import cresla.interfaces.Identifiable;

public class ReportCommand extends Command {

    @Override
    public String execute() {
        if (super.getRepository().getAllReactors().containsKey(Integer.parseInt(getCommands().get(1)))){
            return super.getRepository().getAllReactors().get(Integer.parseInt(getCommands().get(1))).toString();
        }
         return super.getRepository().getReactorsAndModuls().get(Integer.parseInt(getCommands().get(1))).toString();
    }
}
