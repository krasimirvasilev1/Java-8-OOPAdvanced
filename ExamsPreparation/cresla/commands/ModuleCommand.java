package cresla.commands;

import cresla.entities.models.modules.CooldownSystem;
import cresla.entities.models.modules.CryogenRod;
import cresla.entities.models.modules.HeatProcessor;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.EnergyModule;

public class ModuleCommand extends Command {

    @Override
    public String execute() {
        AbsorbingModule absorbingModule;
        EnergyModule energyModule;
        String output;
        int idNumber = super.getRepository().getReactorsAndModuls().size() + super.getIdCounter();
        if (getCommands().get(2).equalsIgnoreCase("CooldownSystem")){
            absorbingModule = new CooldownSystem(idNumber, Integer.parseInt(getCommands().get(3)));
            super.getRepository().getAllReactors().get(Integer.parseInt(getCommands().get(1))).addAbsorbingModule(absorbingModule);
            super.getRepository().getReactorsAndModuls().put(idNumber,absorbingModule);
            super.getRepository().increaseAbsorbingModulesCounter();
            output = String.format("Added CooldownSystem - %d to Reactor - %s",idNumber,getCommands().get(1));
        }
        else if (getCommands().get(2).equalsIgnoreCase("CryogenRod")){
            energyModule = new CryogenRod(idNumber, Integer.parseInt(getCommands().get(3)));
            super.getRepository().getAllReactors().get(Integer.parseInt(getCommands().get(1))).addEnergyModule(energyModule);
            super.getRepository().getReactorsAndModuls().put(idNumber,energyModule);
            super.getRepository().increaseEnergyModulesCounter();
            output = String.format("Added CryogenRod - %d to Reactor - %s",idNumber,getCommands().get(1));
        }
        else{
            absorbingModule = new HeatProcessor(idNumber, Integer.parseInt(getCommands().get(3)));
            super.getRepository().getAllReactors().get(Integer.parseInt(getCommands().get(1))).addAbsorbingModule(absorbingModule);
            super.getRepository().getReactorsAndModuls().put(idNumber,absorbingModule);
            super.getRepository().increaseAbsorbingModulesCounter();
            output = String.format("Added HeatProcessor - %d to Reactor - %s",idNumber,getCommands().get(1));
        }

        return output;
    }
}
