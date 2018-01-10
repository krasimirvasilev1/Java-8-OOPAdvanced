package hell.commands;

import hell.entities.models.items.CommonItem;
import hell.interfaces.Item;

public class ItemCommand extends BaseCommand{

    @Override
    public String execute() {
        String heroName = getParams().get(2);
        Item commonItem = new CommonItem(getParams().get(1), Integer.parseInt(getParams().get(3)), Integer.parseInt(getParams().get(4)), Integer.parseInt(getParams().get(5)), Integer.parseInt(getParams().get(6)), Integer.parseInt(getParams().get(7)));

        super.getRepository().addItemToHero(heroName,commonItem);

        return String.format("Added item - %s to Hero - %s",commonItem.getName(),heroName);

    }
}
