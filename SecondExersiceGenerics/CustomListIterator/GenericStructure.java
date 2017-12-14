package SecondExersiceGenerics.CustomListIterator;

import java.util.*;

public class GenericStructure<T extends Comparable<T>> {

    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public GenericStructure() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        this.list.add(element);
    }

    public void remove(int index) {
        this.list.remove(index);
    }

    public boolean contains(T element) {
        if (this.list.contains(element)) {
            return true;
        } else {
            return false;
        }
    }

    public void swap(int indexOne, int indexTwo) {
        Collections.swap(this.list, indexOne, indexTwo);
    }

    public int greaterElement(T element) {
        int counter = 0;
        for (T t : this.list) {
            if (t.compareTo(element) > 0) {
                counter++;
            }
        }
        return counter;
    }

    public T getMax() {
        T max = this.list.get(0);
        for (T t : this.list) {
            if (max.compareTo(t) < 0) {
                max = t;
            }
        }
        return max;
    }

    public T getMin() {
        T min = this.list.get(0);
        for (T t : this.list) {
            if (min.compareTo(t) > 0) {
                min = t;
            }
        }
        return min;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T t : list) {
            builder.append(t);
            builder.append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
