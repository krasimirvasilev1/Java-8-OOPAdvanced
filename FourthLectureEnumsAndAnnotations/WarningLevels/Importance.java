package FourthLectureEnumsAndAnnotations.WarningLevels;

public enum Importance {
    LOW(1),NORMAL(2),MEDIUM(3),HIGH(4);

    private int value;

    Importance(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return super.name();
    }
}
