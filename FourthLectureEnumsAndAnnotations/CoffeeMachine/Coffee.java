package FourthLectureEnumsAndAnnotations.CoffeeMachine;

public class Coffee {
    private CoffeeType type;
    private CoffeeSize size;

    public Coffee(String type, String size) {
        this.type = CoffeeType.valueOf(type.toUpperCase());
        this.size = CoffeeSize.valueOf(size.toUpperCase());
    }

    @Override
    public String toString() {
        return this.size + " " + this.type;
    }
}
