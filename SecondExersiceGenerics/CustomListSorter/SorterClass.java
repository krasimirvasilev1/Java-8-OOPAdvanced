package SecondExersiceGenerics.CustomListSorter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SorterClass <T extends Comparable<T>> extends GenericStructure{

    public static <T extends Comparable> void sort(List<T> list){
        Collections.sort(list, Comparator.naturalOrder());
    }
}
