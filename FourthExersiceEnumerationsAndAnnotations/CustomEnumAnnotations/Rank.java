package FourthExersiceEnumerationsAndAnnotations.CustomEnumAnnotations;

@ClassAnnotation(category = "Rank",description = "Provides rank constants for a Card class.")
public enum Rank {
    ACE(14) ,TWO (2), THREE(3), FOUR (4), FIVE (5), SIX (6), SEVEN (7), EIGHT (8), NINE (9),
    TEN (10), JACK (11), QUEEN (12), KING (13);

    private int suit;

    Rank(int suit) {
        this.suit = suit;
    }

    public int getSuit() {
        return this.suit;
    }


    @Override
    public String toString() {
        return "Type = "+this.getClass().getAnnotation(ClassAnnotation.class).type()+", Description = "+this.getClass().getAnnotation(ClassAnnotation.class).description();
    }
}
