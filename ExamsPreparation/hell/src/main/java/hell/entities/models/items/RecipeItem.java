package hell.entities.models.items;


import hell.interfaces.Recipe;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class RecipeItem extends ItemImpl implements Recipe {
    private List<String> requiredItems;

    public RecipeItem(String name, int strenthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus, int damageBonus,String ... requiredItems) {
        super(name, strenthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
        this.requiredItems = Arrays.asList(requiredItems);
    }

    @Override
    public List<String> getRequiredItems() {
        return this.requiredItems;
    }
}
