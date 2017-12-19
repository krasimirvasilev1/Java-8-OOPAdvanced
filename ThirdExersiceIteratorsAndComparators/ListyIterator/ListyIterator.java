package ThirdExersiceIteratorsAndComparators.ListyIterator;

import java.util.Arrays;
import java.util.List;

public class ListyIterator {

    private List<String> strings;
    private int index;

    public ListyIterator(String... strings) {
        this.strings = Arrays.asList(strings);
        this.index = 0;
    }

    public List<String> getStrings() {
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

    public String print(){
        return this.strings.get(this.index);
    }

}
