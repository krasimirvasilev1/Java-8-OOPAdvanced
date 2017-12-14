package SecondExersiceGenerics.Threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static <T> void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String[] input = console.readLine().split("\\s+");
        String[] input2 = console.readLine().split("\\s+");
        String[] input3 = console.readLine().split("\\s+");

        boolean drunkOrNot = false;
        if (input2[2].equalsIgnoreCase("drunk")){
            drunkOrNot = true;
        }
        Threeuple tuple = new Threeuple(input[0]+" "+input[1],input[2],input[3]);
        Threeuple tuple1 = new Threeuple(input2[0],Integer.parseInt(input2[1]),drunkOrNot);
        Threeuple tuple2 = new Threeuple(input3[0],Double.parseDouble(input3[1]),input3[2]);

        System.out.println(tuple);
        System.out.println(tuple1);
        System.out.println(tuple2);
    }
}
