package SecondLectureGenerics.NullFinder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers,1,2,3,null,5,null);

        List<Integer> indexes = ListUtils.getNullIndices(integers);

        List<String> strings = new ArrayList<>();
        Collections.addAll(strings,"1",null,"2",null);

        List<Integer> indexes1 = ListUtils.getNullIndices(strings);

        System.out.println(indexes);
        System.out.println(indexes1);
    }
}
