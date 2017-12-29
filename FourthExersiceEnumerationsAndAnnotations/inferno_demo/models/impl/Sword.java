package FourthExersiceEnumerationsAndAnnotations.inferno_demo.models.impl;

import FourthExersiceEnumerationsAndAnnotations.inferno_demo.enumerations.WeaponTypes;

public class Sword extends Weapon {
    public Sword(String name) {
        super(name, WeaponTypes.SWORD.getMinDamage(), WeaponTypes.SWORD.getMaxDamage(), WeaponTypes.SWORD.getSockets());
    }
}
