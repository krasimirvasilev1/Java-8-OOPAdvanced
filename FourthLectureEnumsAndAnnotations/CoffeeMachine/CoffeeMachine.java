package FourthLectureEnumsAndAnnotations.CoffeeMachine;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {
    List<Coffee> coffees;
    private List<Coin> coins;

    public CoffeeMachine() {
        this.coffees = new ArrayList<>();
        this.coins = new ArrayList<>();
    }

    public void buyCoffee(String size, String type) {
        int coinsInTheMachine = this.coins.stream().mapToInt(Coin::getValue).sum();

        if (CoffeeSize.valueOf(size.toUpperCase()).getPrice() <= coinsInTheMachine){
            this.coffees.add(new Coffee(type,size));
            this.coins.clear();
        }

    }

    public void insertCoin(String coin){
        this.coins.add(Coin.valueOf(coin));
    }

    public Iterable<Coffee> coffeesSold() {
        return this.coffees;
    }
}
