package SecondExersiceGenerics.GenericSwapMethodStrings;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int numberOfInputs = Integer.parseInt(console.readLine());
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < numberOfInputs; i++) {
            String input = console.readLine();
            strings.add(input);
        }
        int[] indexes = Arrays.stream(console.readLine().split("\\s+")).mapToInt(x -> Integer.parseInt(x)).toArray();
        List<String> swapedString = GenericBox.swapElements(strings,indexes[0],indexes[1]);

        for (String s : swapedString) {
            System.out.println("java.lang.String: "+s);
        }
    }
}
