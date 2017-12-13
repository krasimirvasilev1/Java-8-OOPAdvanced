package SecondLectureGenerics.GenericFlatMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main (String[] args){
        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 1, 2, 3, 4, 5);

        List<Double> doubles = new ArrayList<>();
        Collections.addAll(doubles, 2.2, 3.3, 4.3, 5.5);

        List<List<? extends Number>> numbers = new ArrayList<>();
        Collections.addAll(numbers,integers,doubles);

        List<? super Number> allElements = new ArrayList<>();
        ListUtils.flatten(allElements,numbers);
    }
}
