package hell.commands;

import hell.entities.miscellaneous.HeroInventory;
import hell.entities.models.heroes.Assassin;
import hell.entities.models.heroes.Barbarian;
import hell.entities.models.heroes.Wizard;
import hell.interfaces.Hero;

public class HeroCommand extends BaseCommand {

    @Override
    public String execute() {
        Hero hero;
        String typeOfHero = super.getParams().get(2);
        if (typeOfHero.equalsIgnoreCase("Barbarian")){
            hero = new Barbarian(super.getParams().get(1),90,25,10,350,150,new HeroInventory());
            super.getRepository().addHero(super.getParams().get(1),hero);
            return String.format("Created Barbarian - %s",hero.getName());
        }
        else if (typeOfHero.equalsIgnoreCase("Assassin")){
            hero = new Assassin(super.getParams().get(1),25,100,15,150,300, new HeroInventory());
            super.getRepository().addHero(super.getParams().get(1),hero);
            return String.format("Created Assassin - %s",hero.getName());
        }
        else{
            hero = new Wizard(super.getParams().get(1),25,25,100,100,250, new HeroInventory());
            super.getRepository().addHero(super.getParams().get(1),hero);
            return String.format("Created Wizard - %s",hero.getName());
        }
    }
}
