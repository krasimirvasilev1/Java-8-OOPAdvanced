package SecondLectureGenerics.GenericArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator {

    public static <T> T[] create(int length, T item ){
        Object [] objects = new Object[length];

        for (int i = 0; i < objects.length; i++) {
            objects[i] = item;
        }

        T [] genericArray = (T[]) objects;
        return genericArray;
    }

    public static <T> T[] create (Class <T> newClass,int length, T item){
        T [] objects = (T[]) Array.newInstance(newClass, length);

        for (int i = 0; i < objects.length; i++) {
            objects[i] = item;
        }

        return objects;
    }
}
