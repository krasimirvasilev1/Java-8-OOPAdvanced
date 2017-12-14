package SecondExersiceGenerics.GenericCountMethodDoubles;

import java.util.Collections;
import java.util.List;

public class GenericBox <T extends Comparable<T>> {

    public static <T> List<T> swapElements (List<T> listOfElements,int firstIndex , int secondIndex){
        Collections.swap(listOfElements,firstIndex,secondIndex);

        return listOfElements;
    }

    public int compare (List<T> list, T element){
        int count = 0;
        for (T t : list) {
            if (t.compareTo(element) > 0){
                count++;
            }
        }
        return count;
    }
}
