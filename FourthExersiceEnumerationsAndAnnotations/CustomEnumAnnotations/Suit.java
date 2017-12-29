package FourthExersiceEnumerationsAndAnnotations.CustomEnumAnnotations;

@ClassAnnotation(category = "Suit",description = "Provides suit constants for a Card class.")
public enum Suit {
    CLUBS (0),DIAMONDS(13),HEARTS(26),SPADES(39);

    private int suitPower;

    Suit(int suitPower) {
        this.suitPower = suitPower;
    }

    public int getSuitPower() {
        return this.suitPower;
    }

    @Override
    public String toString() {
        return "Type = "+this.getClass().getAnnotation(ClassAnnotation.class).type()+", Description = "+this.getClass().getAnnotation(ClassAnnotation.class).description();
    }
}
