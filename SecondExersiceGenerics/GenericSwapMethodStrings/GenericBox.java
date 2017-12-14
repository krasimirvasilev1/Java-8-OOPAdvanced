package SecondExersiceGenerics.GenericSwapMethodStrings;

import java.util.Collections;
import java.util.List;

public class GenericBox <T> {

    public static <T> List<T> swapElements (List<T> listOfElements,int firstIndex , int secondIndex){
        Collections.swap(listOfElements,firstIndex,secondIndex);

        return listOfElements;
    }

}
