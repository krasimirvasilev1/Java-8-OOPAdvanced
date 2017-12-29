package FourthExersiceEnumerationsAndAnnotations.CardsWithPower;

public class CardPower {

    public static void cardPower (String rank , String suit){
        DeckOfCards deckOfCards = Enum.valueOf(DeckOfCards.class,rank.toUpperCase());
        SuitPower suitPower = Enum.valueOf(SuitPower.class,suit.toUpperCase());

        int power = deckOfCards.getSuit() + suitPower.getSuitPower();

        System.out.println("Card name: "+deckOfCards.name()+" of "+suitPower.name()+"; "+"Card power: "+power);
    }
}
