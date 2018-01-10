package hell.repository;

import hell.interfaces.Hero;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.util.LinkedHashMap;
import java.util.Map;

public class RepositoryImpl implements Repository {
    private Map<String , Hero> heroes;

    public RepositoryImpl() {
        this.heroes = new LinkedHashMap<>();
    }

    public void addHero(String name , Hero hero){
        this.heroes.put(name,hero);
    }

    @Override
    public void addItemToHero(String heroName, Item item) {
        this.heroes.get(heroName).addItem(item);
    }

    @Override
    public void addRecipeToHero(String heroName, Recipe recipe) {
        this.heroes.get(heroName).addRecipe(recipe);
    }

    @Override
    public Map<String, Hero> getHeroes() {
        return this.heroes;
    }
}
