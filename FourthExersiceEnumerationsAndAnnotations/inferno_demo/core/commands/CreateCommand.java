package FourthExersiceEnumerationsAndAnnotations.inferno_demo.core.commands;

import FourthExersiceEnumerationsAndAnnotations.inferno_demo.models.api.WeaponInterface;
import FourthExersiceEnumerationsAndAnnotations.inferno_demo.core.BaseCommand;
import FourthExersiceEnumerationsAndAnnotations.inferno_demo.factories.WeaponFactory;

public class CreateCommand extends BaseCommand {
    @Override
    public String execute() {
        WeaponInterface weaponInterface = null;
        switch (super.getParams()[0]) {
            case "AXE":
                weaponInterface = WeaponFactory.createAxeWeapon(super.getParams()[1]);
                break;
            case "SWORD":
                weaponInterface = WeaponFactory.createSwordWeapon(super.getParams()[1]);
                break;
            case "KNIFE":
                weaponInterface = WeaponFactory.createKnifeWeapon(super.getParams()[1]);
                break;
        }
        super.getWeaponRepository().add(weaponInterface);
        return null;
    }
}
