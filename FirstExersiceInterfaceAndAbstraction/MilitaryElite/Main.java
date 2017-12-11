package FirstExersiceInterfaceAndAbstraction.MilitaryElite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Private> privates = new HashMap<>();

        while (true) {
            String input = console.readLine();
            if (input.equalsIgnoreCase("End")) {
                break;
            }
            String[] commands = input.split("\\s+");
            try {
                switch (commands[0]) {
                    case "Private":
                        Private newPrivate = new Private(commands[1], commands[2], commands[3], Double.parseDouble(commands[4]));
                        privates.put(commands[1], newPrivate);
                        System.out.print(newPrivate);
                        break;
                    case "LeutenantGeneral":
                        LeutenantGeneral leutenantGeneral = new LeutenantGeneral(commands[1], commands[2], commands[3], Double.parseDouble(commands[4]));
                        for (int i = 5; i < commands.length; i++) {
                            leutenantGeneral.addPrivate(privates.get(commands[i]));
                        }
                        System.out.print(leutenantGeneral);
                        break;
                    case "Engineer":
                        Engineer engineer = new Engineer(commands[1], commands[2], commands[3], Double.parseDouble(commands[4]), commands[5]);
                        for (int i = 6; i < commands.length; i += 2) {
                            Repair repair = new Repair(commands[i], Integer.parseInt(commands[i+1]));
                            engineer.addRepair(repair);
                        }
                        System.out.print(engineer);
                        break;
                    case "Commando":
                        Commando commando = new Commando(commands[1], commands[2], commands[3], Double.parseDouble(commands[4]), commands[5]);
                        for (int i = 6; i < commands.length; i += 2) {
                            Mission mission = new Mission(commands[i], commands[i+1]);
                            if (mission.getState() != null) {
                                commando.addMission(mission);
                            }
                        }
                        System.out.print(commando);
                        break;
                    case "Spy":
                        Spy spy = new Spy(commands[1], commands[2], commands[3], commands[4]);
                        System.out.print(spy);
                        break;
                }
            } catch (IllegalArgumentException iae) {

            }
        }
    }
}
