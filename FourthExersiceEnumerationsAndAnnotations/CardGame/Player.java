package FourthExersiceEnumerationsAndAnnotations.CardGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player implements Comparable<Player>{
    private String name;
    private Map<SuitPower, List<DeckOfCards>> firstPlayerCards = new HashMap<>();
    private int numberOfCardsInHand;

    public Player(String name) {
        this.name = name;
        this.firstPlayerCards = new HashMap<>();
        this.numberOfCardsInHand = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getNumberOfCardsInHand() {
        return this.numberOfCardsInHand;
    }

    public Map<SuitPower, List<DeckOfCards>> getFirstPlayerCards() {
        return this.firstPlayerCards;
    }

    public void addCard(SuitPower suitPower, DeckOfCards deckOfCards) {
        if (getFirstPlayerCards().containsKey(suitPower)){
            getFirstPlayerCards().get(suitPower).add(deckOfCards);
        }
        else {
            getFirstPlayerCards().put(suitPower,new ArrayList<>());
            getFirstPlayerCards().get(suitPower).add(deckOfCards);
        }
        this.numberOfCardsInHand++;
    }

    public CardPower strongestCardInHand(){
        CardPower strongestCard = null;
        for (SuitPower suitPower : firstPlayerCards.keySet()) {
            for (DeckOfCards deckOfCards : firstPlayerCards.get(suitPower)) {
                CardPower card = new CardPower(deckOfCards,suitPower);
                if (strongestCard == null){
                    strongestCard = card;
                }
                else if (card.getCardPower() > strongestCard.getCardPower()){
                    strongestCard = card;
                }
            }
        }

        return strongestCard;
    }

    @Override
    public int compareTo(Player o) {
        return Integer.compare(this.strongestCardInHand().getCardPower(),o.strongestCardInHand().getCardPower());
    }
}
