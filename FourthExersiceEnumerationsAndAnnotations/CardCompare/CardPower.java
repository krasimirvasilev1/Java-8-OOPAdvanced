package FourthExersiceEnumerationsAndAnnotations.CardCompare;

public class CardPower implements Comparable<CardPower>{

    private DeckOfCards deckOfCards;
    private SuitPower suitPower;
    private int cardPower;

    public CardPower(String deckOfCards, String suitPower) {
        this.deckOfCards = Enum.valueOf(DeckOfCards.class,deckOfCards.toUpperCase());
        this.suitPower = Enum.valueOf(SuitPower.class,suitPower.toUpperCase());
        this.cardPower = this.deckOfCards.getSuit() + this.suitPower.getSuitPower();
    }



    @Override
    public String toString() {
        return String.format("Card name: "+deckOfCards.name()+" of "+suitPower.name()+"; "+"Card power: "+cardPower);
    }

    @Override
    public int compareTo(CardPower o) {
        return Integer.compare(this.cardPower,o.cardPower);
    }
}
