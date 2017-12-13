package SecondLectureGenerics.ListUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Double> doubles = new ArrayList<>();
        List<String> strings = new ArrayList<>();

        Collections.addAll(doubles,2.2,3.5,8.4,3.3,4.2);
        Collections.addAll(strings,"paca","pac");

        System.out.println(ListUtils.getMin(doubles));
        System.out.println(ListUtils.getMax(strings));
    }
}
