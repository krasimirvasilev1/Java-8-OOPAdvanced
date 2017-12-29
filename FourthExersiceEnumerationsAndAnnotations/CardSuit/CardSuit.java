package FourthExersiceEnumerationsAndAnnotations.CardSuit;

public enum CardSuit {
    CLUBS,DIAMONDS,HEARTS,SPADES;


    @Override
    public String toString() {
        return String.format("Ordinal value: "+this.ordinal()+"; "+"Name value: "+this.name());
    }
}
