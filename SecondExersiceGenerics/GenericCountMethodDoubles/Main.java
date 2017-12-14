package SecondExersiceGenerics.GenericCountMethodDoubles;


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
            Double element = Double.parseDouble(console.readLine());
            list.add((T)element);
        }
        double elementToCompare = Double.parseDouble(console.readLine());

        GenericBox genericBox = new GenericBox();

        System.out.println(genericBox.compare(list,elementToCompare));
    }
}
