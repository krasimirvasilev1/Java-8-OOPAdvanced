package ThirdExersiceIteratorsAndComparators.StackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        StackClass stackClass = new StackClass();

        while (true) {
            String input = console.readLine();
            if (input.equalsIgnoreCase("END")) {
                break;
            }
            String[] command = input.split("\\s+");

            try {
                switch (command[0]) {
                    case "Push":
                        for (int i = 1; i < command.length; i++) {
                            int number = Integer.parseInt(command[i].replace(",", ""));
                            stackClass.push(number);
                        }
                        break;
                    case "Pop":
                        stackClass.pop();
                        break;
                }
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }

        for (int i = 0; i < 2; i++) {
            for (Object aClass : stackClass) {
                System.out.println(aClass);
            }
        }
    }
}
