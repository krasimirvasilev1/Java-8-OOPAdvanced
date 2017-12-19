package ThirdExersiceIteratorsAndComparators.PetClinics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(console.readLine());
        PetClinics petClinics = new PetClinics();
        for (int i = 0; i < number; i++) {
            String[] commands = console.readLine().split("\\s+");
            try {
                switch (commands[0]) {
                    case "Create":
                        if (commands[1].equalsIgnoreCase("Pet")) {
                            petClinics.createPet(commands[2], Integer.parseInt(commands[3]), commands[4]);
                        } else if (commands[1].equalsIgnoreCase("Clinic")) {
                            petClinics.createClinic(commands[2], Integer.parseInt(commands[3]));
                        }
                        break;
                    case "add":
                        System.out.println(petClinics.add(commands[1], commands[2]));
                        break;
                    case "Release":
                        System.out.println(petClinics.release(commands[1]));
                        break;
                    case "HasEmptyRooms":
                        System.out.println(petClinics.hasEmptyRooms(commands[1]));
                        break;
                    case "Print":
                        if (commands.length == 2){
                            petClinics.print(commands[1]);
                        }
                        else if (commands.length == 3){
                            petClinics.printClinicRoom(commands[1],Integer.parseInt(commands[2]));
                        }
                }
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }
}
