package ThirdExersiceIteratorsAndComparators.ListyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        ListyIterator listyIterator = new ListyIterator();

        while (true) {
            String input = console.readLine();
            if (input.equalsIgnoreCase("END")) {
                break;
            }
            String[] commands = input.split("\\s+");

            switch (commands[0]) {
                case "Create":
                    if (commands.length != 1) {
                        String[] elements = Arrays.copyOfRange(commands, 1, commands.length);
                        listyIterator = new ListyIterator(elements);
                    }
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "Print":
                    if (listyIterator.getStrings().isEmpty()){
                        System.out.println("Invalid Operation!");
                    }
                    else{
                        System.out.println(listyIterator.print());
                    }
                    break;
            }
        }
    }
}
