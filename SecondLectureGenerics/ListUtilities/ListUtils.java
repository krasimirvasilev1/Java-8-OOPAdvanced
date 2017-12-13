package SecondLectureGenerics.ListUtilities;

import java.util.List;

public class ListUtils {

    public static <T extends Comparable<T>> T getMin(List<T> list){
        if (list.isEmpty()){
            throw new IllegalArgumentException();
        }
        T minimumElement = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (minimumElement.compareTo(list.get(i)) > 0){
                minimumElement = list.get(i);
            }
        }
        return minimumElement;
    }

    public static <T extends Comparable<T>> T getMax(List<T> list){
        if (list.isEmpty()){
            throw new IllegalArgumentException();
        }
        T maximumElement = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (maximumElement.compareTo(list.get(i)) < 0){
                maximumElement = list.get(i);
            }
        }
        return maximumElement;
    }
}
