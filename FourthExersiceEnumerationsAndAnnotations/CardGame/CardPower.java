package FourthExersiceEnumerationsAndAnnotations.CardGame;

public class CardPower {
    private DeckOfCards cardType;
    private SuitPower suit;
    private int cardPower;

    public CardPower(DeckOfCards cardType, SuitPower suit) {
        this.cardType = cardType;
        this.suit = suit;
        this.cardPower = cardType.getSuit() + suit.getSuitPower();
    }

    public DeckOfCards getCardType() {
        return this.cardType;
    }

    public SuitPower getSuit() {
        return this.suit;
    }

    public int getCardPower() {
        return this.cardPower;
    }
}
