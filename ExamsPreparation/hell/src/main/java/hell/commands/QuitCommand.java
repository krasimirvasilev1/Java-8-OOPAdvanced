package hell.commands;

import hell.interfaces.Hero;
import hell.interfaces.Item;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class QuitCommand extends BaseCommand {
    private int counter = 1;
    @Override
    public String execute(){

        StringBuilder builder = new StringBuilder();

        getRepository().getHeroes().entrySet().stream().sorted((x,y) -> CompareTheOutput(x.getValue(),y.getValue()))
                .forEach(x -> {
                    List<String> itemsPerHero = new ArrayList<>();
                    try {
                        for (Item item : x.getValue().getItems()) {
                            itemsPerHero.add(item.getName());
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    builder.append(String.format("%d. %s: %s%n###HitPoints: %d%n###Damage: %d%n###Strength: %d%n###Agility: %d%n###Intelligence: %d%n"
                            ,this.counter,x.getValue().getClass().getSimpleName(),x.getValue().getName(),x.getValue().getHitPoints(),x.getValue().getDamage(),x.getValue().getStrength(),x.getValue().getAgility(),x.getValue().getIntelligence()));

                    if (itemsPerHero.size() == 0){
                        builder.append(String.format("###Items: None%n"));
                    }
                    else {
                        builder.append(String.format("###Items: %s%n",String.join(", ",itemsPerHero)));
                    }

                    this.increaseCounterValue();
                        });

        return builder.toString().trim();
    }

    private int CompareTheOutput(Hero value, Hero value1) {
        int firstCompare = Long.compare(value1.getStrength()+value1.getAgility()+value1.getIntelligence(),
                value.getStrength()+value.getAgility()+value.getIntelligence());
        if (firstCompare != 0){
            return firstCompare;
        }

        return Long.compare(value1.getHitPoints()+value1.getDamage(),
                value.getHitPoints()+value.getDamage());
    }

    private void increaseCounterValue(){
        this.counter++;
    }
}
