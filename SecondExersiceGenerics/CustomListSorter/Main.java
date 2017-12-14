package SecondExersiceGenerics.CustomListSorter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        SorterClass sorterClass = new SorterClass();
        while(true){
            String input = console.readLine();
            if (input.equalsIgnoreCase("END")){
                break;
            }
            String[] arrayOfCommands = input.split("\\s+");
            switch(arrayOfCommands[0]){
                case "add":
                    sorterClass.add(arrayOfCommands[1]);
                    break;
                case "Remove":
                    sorterClass.remove(Integer.parseInt(arrayOfCommands[1]));
                    break;
                case "Contains":
                    System.out.println(sorterClass.contains(arrayOfCommands[1]));
                    break;
                case "Swap":
                    sorterClass.swap(Integer.parseInt(arrayOfCommands[1]),Integer.parseInt(arrayOfCommands[2]));
                    break;
                case "Greater":
                    System.out.println(sorterClass.greaterElement(arrayOfCommands[1]));
                    break;
                case "Max":
                    System.out.println(sorterClass.getMax());
                    break;
                case "Min":
                    System.out.println(sorterClass.getMin());
                    break;
                case "Print":
                    System.out.println(sorterClass);
                    break;
                case "Sort":
                    SorterClass.sort(sorterClass.getList());
            }
        }
    }
}
