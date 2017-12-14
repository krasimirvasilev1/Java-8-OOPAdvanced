package SecondExersiceGenerics.Threeuple;

public class Threeuple<T,E,P> {

    private T item;
    private E item2;
    private P item3;

    public Threeuple(T item, E item2, P item3) {
        this.item = item;
        this.item2 = item2;
        this.item3 = item3;
    }

    public T getItem() {
        return item;
    }

    public E getItem2() {
        return item2;
    }

    public P getItem3() {
        return item3;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s",this.item,this.item2,this.item3);
    }
}
