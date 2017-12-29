package FourthExersiceEnumerationsAndAnnotations.CardGame;

public enum SuitPower {
    CLUBS (0),DIAMONDS(13),HEARTS(26),SPADES(39);

    private int suitPower;

    SuitPower(int suitPower) {
        this.suitPower = suitPower;
    }

    public int getSuitPower() {
        return this.suitPower;
    }

    public static boolean isTheCardSuitPresent(String type){
        for (SuitPower suitPower : SuitPower.values()) {
            if (type.equals(suitPower.name())){
                return true;
            }
        }
        return false;
    }
}
