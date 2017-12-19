package ThirdExersiceIteratorsAndComparators.Froggy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lake <T extends Integer> implements Iterable<Integer> {

    private List<Integer> frogJumps;

    public Lake() {
        this.frogJumps = new ArrayList<>();
    }

    public void add(int element){
        this.frogJumps.add(element);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }


    private final class Frog implements Iterator<Integer> {

        private int index;
        private boolean isTheEvenOver;
        private boolean isTheOddOver;

        public Frog() {
            this.index = -1;
            isTheEvenOver = false;
            isTheOddOver = false;
        }

        @Override
        public boolean hasNext() {
            if (isTheEvenOver && isTheOddOver) {
                return false;
            }
            return true;
        }

        @Override
        public Integer next() {
            if (!isTheEvenOver) {
                for (int i = index; i < frogJumps.size(); i++) {
                    if (i % 2 == 0 && i > index) {
                        index = i;
                        return frogJumps.get(index);
                    }
                }
                index = 0;
                isTheEvenOver = true;
            }
            for (int i = 0; i < frogJumps.size(); i++) {
                if (i % 2 == 1 && i > index){
                    index = i;
                    return frogJumps.get(index);
                }
            }
            isTheOddOver = true;
            return null;
        }
    }

    @Override
    public String toString() {
        List<String> output = new ArrayList<>();
        for (Integer frogJump : frogJumps) {
            output.add(frogJump.toString());
        }
        return String.join(", ", output);
    }
}
