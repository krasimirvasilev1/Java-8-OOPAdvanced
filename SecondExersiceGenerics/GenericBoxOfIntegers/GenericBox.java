package SecondExersiceGenerics.GenericBoxOfIntegers;

public class GenericBox <T> {
    private T something;

    public GenericBox(T something) {
        this.something = something;
    }

    @Override
    public String toString() {
        return "java.lang.Integer:"+" "+this.something;
    }
}
