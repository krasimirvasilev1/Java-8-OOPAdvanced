package ThirdExersiceIteratorsAndComparators.StackIterator;

import java.util.*;

public class StackClass<T extends Integer> implements Stack<Integer>, Iterable<Integer> {

    private List<Integer> integers;

    public StackClass() {
         this.integers = new ArrayList<>();
    }

    @Override
    public void pop(){
        if (!this.integers.isEmpty()) {
            this.integers.remove(this.integers.size() - 1);
        }
        else{
            throw new IllegalArgumentException("No Elements");
        }
    }

    @Override
    public void push(Integer integer) {
        this.integers.add(integer);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator1();
    }

    private final class Iterator1 implements Iterator<Integer>{

        private int index;

        public Iterator1() {
            this.index = integers.size() - 1;
        }

        @Override
        public boolean hasNext() {
            return  this.index >= 0;
        }

        @Override
        public Integer next() {
            return integers.get(index--);
        }
    }
}
