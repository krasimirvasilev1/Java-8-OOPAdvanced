package hell.repository;


import hell.interfaces.Hero;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.util.Map;

public interface Repository{

    void addHero(String name, Hero hero);

    void addItemToHero(String heroName, Item item );

    void addRecipeToHero(String heroName, Recipe recipe);

    Map<String, Hero> getHeroes();

}
