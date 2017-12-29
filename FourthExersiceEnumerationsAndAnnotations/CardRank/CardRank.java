package FourthExersiceEnumerationsAndAnnotations.CardRank;

public enum CardRank {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;

    @Override
    public String toString() {
        return String.format("Ordinal value: "+this.ordinal()+"; "+"Name value: "+this.name());
    }
}
