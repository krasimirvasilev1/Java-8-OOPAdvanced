package FourthExersiceEnumerationsAndAnnotations.InfernoInfinity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Weapon> weapons = new LinkedHashMap<>();

        while (true) {
            String input = console.readLine();
            if (input.equalsIgnoreCase("END")) {
                break;
            }
            String[] commands = input.split(";");
            switch (commands[0].toLowerCase()) {
                case "create":
                    switch (commands[1].toLowerCase()) {
                        case "axe":
                            Axe axe = new Axe(commands[2]);
                            weapons.put(commands[2], axe);
                            break;
                        case "sword":
                            Sword sword = new Sword(commands[2]);
                            weapons.put(commands[2], sword);
                            break;
                        case "knife":
                            Knife knife = new Knife(commands[2]);
                            weapons.put(commands[2], knife);
                            break;
                    }
                    break;
                case "add":
                    if (weapons.containsKey(commands[1])) {
                        Weapon weapon = weapons.get(commands[1]);
                        weapon.setGem(Integer.parseInt(commands[2]), Enum.valueOf(Gems.class, commands[3].toUpperCase()));
                        weapons.put(commands[1], weapon);
                    }
                    break;
                case "remove":
                    if (weapons.containsKey(commands[1])) {
                        Weapon weapon = weapons.get(commands[1]);
                        weapon.removeGem(Integer.parseInt(commands[2]));
                        weapons.put(commands[1], weapon);
                    }
                    break;
                case "print":
                    if (weapons.containsKey(commands[1])) {
                        Weapon weapon = weapons.get(commands[1]);
                        weapon.calculateTheWeaponPoints(weapon.getMinDamage(),weapon.getMaxDamage());

                        System.out.println(weapon);

                        weapon.setMinDamage(0);
                        weapon.setMaxDamage(0);
                    }
                    break;
                case "compare":
                    if (weapons.containsKey(commands[1]) && weapons.containsKey(commands[2])) {
                        Weapon weapon = weapons.get(commands[1]);
                        Weapon otherWeapon = weapons.get(commands[2]);
                        weapon.calculateItemLevel(weapon.getMinDamage(),weapon.getMaxDamage());
                        otherWeapon.calculateItemLevel(otherWeapon.getMinDamage(),otherWeapon.getMaxDamage());

                        int compareResult = weapon.compareTo(otherWeapon);
                        if (compareResult > 0) {
                            System.out.println(weapon.printBiggerElement(weapon));
                        } else if (compareResult < 0) {
                            System.out.println(otherWeapon.printBiggerElement(otherWeapon));
                        } else {
                            System.out.println(weapon.printBiggerElement(weapon));
                        }

                        weapon.setMinDamage(0);
                        weapon.setMaxDamage(0);
                        otherWeapon.setMinDamage(0);
                        otherWeapon.setMaxDamage(0);
                    }
                    break;
            }
        }
    }
}
