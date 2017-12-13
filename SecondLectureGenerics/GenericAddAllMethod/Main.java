package SecondLectureGenerics.GenericAddAllMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main (String[] args){
        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers,1,2,3,4,5);

        List<Double> doubles = new ArrayList<>();
        Collections.addAll(doubles,2.3,3.5,4.6);

        List<Number> destination = new ArrayList<>();
        ListUtils.addAll(destination,integers);
        ListUtils.addAll(destination,doubles);
    }
}
