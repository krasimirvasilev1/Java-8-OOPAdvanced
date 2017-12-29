package FourthExersiceEnumerationsAndAnnotations.inferno_infinityMine;

import FourthExersiceEnumerationsAndAnnotations.inferno_infinityMine.classes.CommandInterpretator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        CommandInterpretator commandInterpretator = new CommandInterpretator();

        while (true){
            String input = console.readLine();

            if (input.equalsIgnoreCase("END")){
                break;
            }
            commandInterpretator.execute(input.split(";"));
        }
    }
}
