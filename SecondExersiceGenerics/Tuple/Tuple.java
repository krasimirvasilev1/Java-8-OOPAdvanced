package SecondExersiceGenerics.Tuple;

public class Tuple <T,E> {

    private T item;
    private E item2;

    public Tuple(T item, E item2) {
        this.item = item;
        this.item2 = item2;
    }

    public T getItem() {
        return item;
    }

    public E getItem2() {
        return item2;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s",this.item,this.item2);
    }
}
