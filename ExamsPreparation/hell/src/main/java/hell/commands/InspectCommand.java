package hell.commands;

import hell.interfaces.Hero;
import hell.interfaces.Item;

public class InspectCommand extends BaseCommand{

    @Override
    public String execute() throws IllegalAccessException {
        Hero currHero = super.getRepository().getHeroes().get(getParams().get(1));

        StringBuilder builder = new StringBuilder();

        builder.append(String.format("Hero: %s, Class: %s%nHitPoints: %d, Damage: %d%nStrength: %d%nAgility: %d%nIntelligence: %d%n",currHero.getName(),currHero.getClass().getSimpleName(),currHero.getHitPoints(),currHero.getDamage(),currHero.getStrength(),currHero.getAgility(),currHero.getIntelligence()));

        if (currHero.getItems().size() == 0){
            builder.append(String.format("Items: None%n"));
        }
        else {
            builder.append(String.format("Items: %n"));
            for (Item item : currHero.getItems()) {
                builder.append(String.format("###Item: %s%n###+%d Strength%n###+%d Agility%n###+%d Intelligence%n###+%d HitPoints%n###+%d Damage%n"
                        , item.getName(), item.getStrengthBonus(), item.getAgilityBonus(), item.getIntelligenceBonus(), item.getHitPointsBonus(), item.getDamageBonus()));
            }
        }

        return builder.toString().trim();
    }
}
