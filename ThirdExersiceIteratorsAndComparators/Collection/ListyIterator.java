package ThirdExersiceIteratorsAndComparators.Collection;

import java.util.*;
import java.util.function.Consumer;

public class  ListyIterator <T> implements Iterable<T> {

    private List<T> strings;
    private int index;

    public ListyIterator(T... strings) {
        this.strings = Arrays.asList(strings);
        this.index = 0;
    }

    public List<T> getStrings() {
        return strings;
    }

    public boolean move (){
        if  (this.index < this.strings.size() - 1){
            this.index++;
            return  true;
        }
        else {
            return false;
        }
    }

    public boolean hasNext(){
        if (index < this.strings.size() - 1){
            return true;
        }
        else {
            return false;
        }
    }

    public T print(){
        return this.strings.get(this.index);
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    public String printAll(){
        StringBuilder builder = new StringBuilder();
        for (T string : strings) {
            builder.append(string + " ");
        }
        return builder.toString().trim();
    }
}
