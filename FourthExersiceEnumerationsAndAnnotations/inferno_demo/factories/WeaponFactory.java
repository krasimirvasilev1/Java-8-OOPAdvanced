package FourthExersiceEnumerationsAndAnnotations.inferno_demo.factories;

import FourthExersiceEnumerationsAndAnnotations.inferno_demo.models.api.WeaponInterface;
import FourthExersiceEnumerationsAndAnnotations.inferno_demo.models.impl.Axe;
import FourthExersiceEnumerationsAndAnnotations.inferno_demo.models.impl.Knife;
import FourthExersiceEnumerationsAndAnnotations.inferno_demo.models.impl.Sword;

public final class WeaponFactory {
    private WeaponFactory() {
    }

    public static WeaponInterface createAxeWeapon(String name) {
        return new Axe(name);
    }

    public static WeaponInterface createSwordWeapon(String name) {
        return new Sword(name);
    }

    public static WeaponInterface createKnifeWeapon(String name) {
        return new Knife(name);
    }
}
