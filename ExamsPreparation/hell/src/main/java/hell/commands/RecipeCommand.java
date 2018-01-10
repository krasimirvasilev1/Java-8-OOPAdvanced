package hell.commands;

import hell.entities.models.items.CommonItem;
import hell.entities.models.items.RecipeItem;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.util.List;

public class RecipeCommand extends BaseCommand {

    @Override
    public String execute() {
        String heroName = getParams().get(2);
        List<String> itemsToFormRecipe = getParams().subList(8,getParams().size());
        String[] itemsToFormRecipeArray = new String[itemsToFormRecipe.size()];
        itemsToFormRecipeArray = itemsToFormRecipe.toArray(itemsToFormRecipeArray);

        Recipe recipe = new RecipeItem(getParams().get(1), Integer.parseInt(getParams().get(3)), Integer.parseInt(getParams().get(4)), Integer.parseInt(getParams().get(5)), Integer.parseInt(getParams().get(6)), Integer.parseInt(getParams().get(7)),itemsToFormRecipeArray);

        super.getRepository().addRecipeToHero(heroName,recipe);

        return String.format("Added recipe - %s to Hero - %s",recipe.getName(),heroName);
    }
}
