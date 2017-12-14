package SecondExersiceGenerics.Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static <T> void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String[] input = console.readLine().split("\\s+");
        String[] input2 = console.readLine().split("\\s+");
        String[] input3 = console.readLine().split("\\s+");

        Tuple tuple = new Tuple(input[0]+" "+input[1],input[2]);
        Tuple tuple1 = new Tuple(input2[0],Integer.parseInt(input2[1]));
        Tuple tuple2 = new Tuple(Integer.parseInt(input3[0]),Double.parseDouble(input3[1]));

        System.out.println(tuple);
        System.out.println(tuple1);
        System.out.println(tuple2);
    }
}
