package FourthExersiceEnumerationsAndAnnotations.inferno_infinityMine.enums;

public enum WeaponType {
    Axe(5,10,4), Sword(4,6,2), Knife(3,4,2);

    private int minimumDamage;
    private int maximumDamage;
    private int sockets;

    WeaponType(int minimumDamage, int maximumDamage, int sockets) {
        this.minimumDamage = minimumDamage;
        this.maximumDamage = maximumDamage;
        this.sockets = sockets;
    }

    public int getMinimumDamage() {
        return this.minimumDamage;
    }

    public int getMaximumDamage() {
        return this.maximumDamage;
    }

    public int getSockets() {
        return this.sockets;
    }
}
