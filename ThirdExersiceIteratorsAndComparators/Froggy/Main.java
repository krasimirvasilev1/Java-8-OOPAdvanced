package ThirdExersiceIteratorsAndComparators.Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int [] numbers = Arrays.stream(console.readLine().split(", |[, ]")).mapToInt(x -> Integer.parseInt(x)).toArray();
        String endComand = console.readLine();
        Lake lake = new Lake();
        for (int number : numbers) {
            lake.add(number);
        }
        StringBuilder builder = new StringBuilder();
        for (Object integer : lake) {
            if (integer != null) {
                builder.append(integer + ", ");
            }
        }
        System.out.println(builder.toString().substring(0,builder.length() - 2));
    }
}
