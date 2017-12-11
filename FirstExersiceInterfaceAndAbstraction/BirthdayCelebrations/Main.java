package FirstExersiceInterfaceAndAbstraction.BirthdayCelebrations;

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
            switch (infoForEveryone[0]) {
                case "Pet":
                    Pet pet = new Pet(infoForEveryone[1], infoForEveryone[2]);
                    all.add(pet);
                    break;
                case "Robot":
                    Robot robot = new Robot(infoForEveryone[1], infoForEveryone[2]);
                    all.add(robot);
                    break;
                case "Citizen":
                    Citizen citizen = new Citizen(infoForEveryone[1], Integer.parseInt(infoForEveryone[2]), infoForEveryone[3], infoForEveryone[4]);
                    all.add(citizen);
                    break;
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
