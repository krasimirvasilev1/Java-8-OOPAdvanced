package SecondExersiceGenerics.GenericBoxOfIntegers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int numbers = Integer.parseInt(console.readLine());
        for (int i = 0; i < numbers; i++) {
            Integer something = Integer.parseInt(console.readLine());
            GenericBox genericBox = new GenericBox(something);
            System.out.println(genericBox);
        }
    }
}
