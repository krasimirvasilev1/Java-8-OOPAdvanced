package FirstExersiceInterfaceAndAbstraction.Mood3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String[] input = console.readLine().split(" \\| ");

        HashedPassword newPlayer = null;
        switch(input[1]){
            case "Demon":
                newPlayer = new Demon(input[0],"",Integer.parseInt(input[3]),Double.parseDouble(input[2]));
                break;
            case "Archangel":
                newPlayer = new Archangel(input[0],"",Integer.parseInt(input[3]),Double.parseDouble(input[2]));
                break;
        }

        System.out.print(newPlayer);
    }
}
