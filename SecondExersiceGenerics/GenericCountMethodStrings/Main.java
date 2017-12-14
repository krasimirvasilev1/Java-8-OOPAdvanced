package SecondExersiceGenerics.GenericCountMethodStrings;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static <T> void  main (String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        List<T> list = new ArrayList<>();
        int numberOfElem = Integer.parseInt(console.readLine());

        for (int i = 0; i < numberOfElem; i++) {
            T element = (T)console.readLine();
            list.add(element);
        }
        T elementToCompare = (T)console.readLine();

        GenericBox genericBox = new GenericBox();

        System.out.println(genericBox.compare(list, (Comparable) elementToCompare));
    }
}
