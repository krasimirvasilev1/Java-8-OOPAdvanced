package FourthExersiceEnumerationsAndAnnotations.DeckOfCards;

public class Main {
    public static void main(String[] args) {

        for ( SuitPower suitPower : SuitPower.values()) {
            for (DeckOfCards deckOfCards : DeckOfCards.values()) {
                System.out.println(deckOfCards.name() + " of " + suitPower.name());
            }
        }
    }
}
