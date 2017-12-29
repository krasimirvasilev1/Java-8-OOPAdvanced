package FourthExersiceEnumerationsAndAnnotations.inferno_infinityMine.classes;

import FourthExersiceEnumerationsAndAnnotations.inferno_infinityMine.annotation.ClassInfo;
import FourthExersiceEnumerationsAndAnnotations.inferno_infinityMine.enums.GemType;
import FourthExersiceEnumerationsAndAnnotations.inferno_infinityMine.enums.TypeGem;
import FourthExersiceEnumerationsAndAnnotations.inferno_infinityMine.enums.TypeWeapon;
import FourthExersiceEnumerationsAndAnnotations.inferno_infinityMine.interfaces.CommandExecuter;
import FourthExersiceEnumerationsAndAnnotations.inferno_infinityMine.interfaces.Weapon;
import FourthExersiceEnumerationsAndAnnotations.inferno_infinityMine.interfaces.Writer;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;

public class CommandInterpreter implements CommandExecuter {
    private HashMap<String, Weapon> weapens;
    private Class<WeaponImpl> weaponClass;
    private Writer writer;

    public CommandInterpreter() {
        this.weapens = new HashMap<>();
        this.weaponClass = WeaponImpl.class;
        this.writer = new OutputWriter();
    }

    @Override
    public void executeCommand(String[] command) {
        switch (command[0]){
            case "Create":
                TypeWeapon weaponType = TypeWeapon.valueOf(command[1].toUpperCase());
                Weapon weapon = new WeaponImpl(weaponType, command[2]);
                weapens.putIfAbsent(command[2],weapon);
                break;
            case "add":
                weapens.get(command[1]).add(Integer.valueOf(command[2]), GemType.valueOf(command[3].toUpperCase()));
                break;
            case "Remove":
                weapens.get(command[1]).remove(Integer.valueOf(command[2]));
                break;
            case "Print":
                writer.print(weapens.get(command[1]).toString());
                break;
            case "Compare":
                Weapon weapon1 = weapens.get(command[1]);
                Weapon weapon2 = weapens.get(command[2]);
                if (weapon1.compareTo(weapon2) < 0){
                    DecimalFormat df = new DecimalFormat("0.0");
                    if (weapon1.compareTo(weapon2) < 0) {
                        writer.print(weapon2 + " (Item Level: " + df.format(weapon2.getItemLevel()) + ")");
                    }  else if (weapon1.compareTo(weapon2) >= 0){
                        writer.print(weapon1 + " (Item Level: " + df.format(weapon1.getItemLevel()) + ")");
                    }
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
