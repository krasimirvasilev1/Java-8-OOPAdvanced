package FirstExersiceInterfaceAndAbstraction.BorderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        List<Checker> all = new ArrayList<>();
        while (true) {
            String input = console.readLine();
            if (input.equalsIgnoreCase("End")) {
                break;
            }
            String[] infoForEveryone = input.split("\\s+");
            if (infoForEveryone.length == 2) {
                Robot robots = new Robot(infoForEveryone[0], infoForEveryone[1]);
                all.add(robots);
            } else if (infoForEveryone.length == 3) {
                Citizen citizen = new Citizen(infoForEveryone[0], Integer.parseInt(infoForEveryone[1]), infoForEveryone[2]);
                all.add(citizen);
            }
        }

        String finalNumber = console.readLine();
        for (Checker checker : all) {
            if (!checker.checker(finalNumber).equalsIgnoreCase("")){
                System.out.println(checker.checker(finalNumber));
            }
        }
    }
}
