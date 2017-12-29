package FourthExersiceEnumerationsAndAnnotations.inferno_infinityMine.classes;

import FourthExersiceEnumerationsAndAnnotations.inferno_infinityMine.annotation.ClassInfo;
import FourthExersiceEnumerationsAndAnnotations.inferno_infinityMine.enums.GemType;
import FourthExersiceEnumerationsAndAnnotations.inferno_infinityMine.interfaces.CommandExecutor;
import FourthExersiceEnumerationsAndAnnotations.inferno_infinityMine.interfaces.Weapon;
import FourthExersiceEnumerationsAndAnnotations.inferno_infinityMine.interfaces.Writer;
import FourthExersiceEnumerationsAndAnnotations.inferno_infinityMine.enums.TypeWeapon;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommandInterpretator implements CommandExecutor {

    private Map<String,Weapon> weapons;
    private Class<WeaponImpl> weaponClass;
    private Writer writer;

    public CommandInterpretator() {
        this.weapons = new HashMap<>();
        this.weaponClass = WeaponImpl.class;
        this.writer = new OutputWriter();
    }

    @Override
    public void execute(String[] command) {
        switch (command[0]){
            case "Create":
                TypeWeapon weaponType = TypeWeapon.valueOf(command[1].toUpperCase());
                Weapon weapon = new WeaponImpl(weaponType, command[2]);
                weapons.putIfAbsent(command[2],weapon);
                break;
            case "add":
                weapons.get(command[1]).add(Integer.valueOf(command[2]), GemType.valueOf(command[3].toUpperCase()));
                break;
            case "Remove":
                weapons.get(command[1]).remove(Integer.valueOf(command[2]));
                break;
            case "Print":
                writer.print(weapons.get(command[1]).toString());
                break;
            case "Compare":
                Weapon weapon1 = weapons.get(command[1]);
                Weapon weapon2 = weapons.get(command[2]);
                    DecimalFormat df = new DecimalFormat("0.0");
                    if (weapon1.compareTo(weapon2) < 0) {
                        writer.print(weapon2 + " (Item Level: " + df.format(weapon2.getItemLevel()) + ")");
                    }  else if (weapon1.compareTo(weapon2) >= 0){
                        writer.print(weapon1 + " (Item Level: " + df.format(weapon1.getItemLevel()) + ")");
                    }
                break;
            case "Author":
                writer.print("Author: " + weaponClass.getAnnotation(ClassInfo.class).author());
                break;
            case "Revision":
                writer.print("Revision: " + weaponClass.getAnnotation(ClassInfo.class).revision());
                break;
            case "Description":
                writer.print("Class description: " + weaponClass.getAnnotation(ClassInfo.class).description());
                break;
            case "Reviewers":
                writer.print("Reviewers: " + Arrays.toString(weaponClass.getAnnotation(ClassInfo.class)
                        .reviewers()).replace("]","").replace("[",""));
                break;
        }
    }
}
