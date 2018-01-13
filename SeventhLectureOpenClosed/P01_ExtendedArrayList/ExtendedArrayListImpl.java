package SeventhLectureOpenClosed.P01_ExtendedArrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class ExtendedArrayListImpl<T extends Comparable> extends ArrayList implements ExtendedArrayList {

    @Override
    public T max(){
        T max = null;
        Iterator<T> iterator = super.iterator();
        while(iterator.hasNext()){
            T nextElement = iterator.next();
            if ((max == null) || (max.compareTo(nextElement) < 0)){
                max = nextElement;
            }
        }
        return max;
    }

    @Override
    public T min(){
        T min = null;
        Iterator<T> iterator = super.iterator();
        while(iterator.hasNext()){
            T nextElement = iterator.next();
            if ((min == null) || min.compareTo(nextElement) > 0){
                min = nextElement;
            }
        }
        return min;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ExtendedArrayList<Integer> newList = new ExtendedArrayListImpl<>();
        newList.add(100);
        newList.add(-120);
        newList.add(50);
        newList.add(500);
        newList.add(5000);
        newList.add(-111111);
        System.out.println(newList.min());
        System.out.println(newList.max());
    }
}
