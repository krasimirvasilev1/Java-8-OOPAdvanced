package FourthExersiceEnumerationsAndAnnotations.inferno_infinityMine.classes;

import FourthExersiceEnumerationsAndAnnotations.inferno_infinityMine.annotation.ClassInfo;
import FourthExersiceEnumerationsAndAnnotations.inferno_infinityMine.enums.GemType;
import FourthExersiceEnumerationsAndAnnotations.inferno_infinityMine.interfaces.Weapon;
import FourthExersiceEnumerationsAndAnnotations.inferno_infinityMine.enums.TypeWeapon;

@ClassInfo(author = "Pesho", revision = 3, description = "Used for Java OOP Advanced course - Enumerations and Annotations.", reviewers = {"Pesho", "Svetlio"}
)
public class WeaponImpl implements Weapon {

    private TypeWeapon typeWeapon;
    private GemType[] gemTypes;
    private String name;

    public WeaponImpl(TypeWeapon typeWeapon, String name) {
        setTypeWeapon(typeWeapon);
        setGemTypes();
        setName(name);
    }

    private void setTypeWeapon(TypeWeapon typeWeapon) {
        this.typeWeapon = typeWeapon;
    }

    private void setGemTypes() {
        this.gemTypes = new GemType[this.typeWeapon.getSockets()];
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getMinDamage() {
        int currMinDamage = this.typeWeapon.getMinDamage();
        for (GemType gemType : gemTypes) {
            if (gemType != null) {
                currMinDamage += gemType.getStrength() * 2;
                currMinDamage += gemType.getAgility();
            }
        }
        return currMinDamage;
    }

    public int getMaxDamage() {
        int currMaxDamage = this.typeWeapon.getMaxDamage();
        for (GemType gemType : gemTypes) {
            if (gemType != null) {
                currMaxDamage += gemType.getStrength() * 3;
                currMaxDamage += gemType.getAgility() * 4;
            }
        }
        return currMaxDamage;
    }

    public int getStrength() {
        int strength = 0;
        for (GemType gemType : gemTypes) {
            if (gemType != null) {
                strength += gemType.getStrength();
            }
        }
        return strength;
    }

    public int getAgility() {
        int agility = 0;
        for (GemType gemType : gemTypes) {
            if (gemType != null) {
                agility += gemType.getAgility();
            }
        }
        return agility;
    }

    public int getVitality() {
        int vitality = 0;
        for (GemType gemType : gemTypes) {
            if (gemType != null) {
                vitality += gemType.getVitality();
            }
        }
        return vitality;
    }

    @Override
    public double getItemLevel() {
        return ((double) (getMinDamage() + getMaxDamage()) / 2) + getStrength() + getAgility() + getVitality();
    }

    @Override
    public void add(int socketIndex, GemType gemType) {
        try {
            this.gemTypes[socketIndex] = gemType;
        } catch (IndexOutOfBoundsException ioobe) {

        }
    }

    @Override
    public void remove(int socketIndex) {
        try {
            this.gemTypes[socketIndex] = null;
        } catch (IndexOutOfBoundsException ioobe) {

        }
    }

    @Override
    public int compareTo(Weapon weapon) {
        return Double.compare(this.getItemLevel(), weapon.getItemLevel());
    }

    @Override
    public String toString() {
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
                this.name, this.getMinDamage(), this.getMaxDamage(), this.getStrength(), this.getAgility(), this.getVitality());
    }
}
