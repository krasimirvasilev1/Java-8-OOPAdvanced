package SecondLectureGenerics.GenericArrayCreator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Object [] strings = ArrayCreator.create(10,"none");
        Integer [] integers = ArrayCreator.create(Integer.class,10,2);

        System.out.println(Arrays.toString(strings));
        System.out.println(Arrays.toString(integers));
    }
}
