package SecondExersiceGenerics.CustomList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        GenericStructure genericBox = new GenericStructure();
        while(true){
            String input = console.readLine();
            if (input.equalsIgnoreCase("END")){
                break;
            }
            String[] arrayOfCommands = input.split("\\s+");
            switch(arrayOfCommands[0]){
                case "add":
                    genericBox.add(arrayOfCommands[1]);
                    break;
                case "Remove":
                    genericBox.remove(Integer.parseInt(arrayOfCommands[1]));
                    break;
                case "Contains":
                    System.out.println(genericBox.contains(arrayOfCommands[1]));
                    break;
                case "Swap":
                    genericBox.swap(Integer.parseInt(arrayOfCommands[1]),Integer.parseInt(arrayOfCommands[2]));
                    break;
                case "Greater":
                    System.out.println(genericBox.greaterElement(arrayOfCommands[1]));
                    break;
                case "Max":
                    System.out.println(genericBox.getMax());
                    break;
                case "Min":
                    System.out.println(genericBox.getMin());
                    break;
                case "Print":
                    System.out.println(genericBox);
                    break;
            }
        }
    }
}
