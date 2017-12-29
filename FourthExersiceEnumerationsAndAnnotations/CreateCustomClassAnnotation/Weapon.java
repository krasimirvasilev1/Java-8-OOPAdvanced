package FourthExersiceEnumerationsAndAnnotations.CreateCustomClassAnnotation;

@CustomAnnotation(author = "Pesho",revision = 3,description = "Used for Java OOP Advanced course - Enumerations and Annotations.",reviewers = {"Pesho","Svetlio"})
public class Weapon implements Comparable<Weapon>{
    private String name;
    private int minDamage;
    private int maxDamage;
    private Gems[] numberOfSockets;
    private int strength = 0;
    private int agility = 0;
    private int vitality = 0;
    private double itemLevel = 0;

    protected Weapon(String name) {
        this.name = name;
        setMinDamage(0);
        setMaxDamage(0);
        setNumberOfSockets(0);
    }

    public int getMinDamage() {
        return this.minDamage;
    }

    public int getMaxDamage() {
        return this.maxDamage;
    }

    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public void setNumberOfSockets(int numberOfSockets) {
        this.numberOfSockets = new Gems[numberOfSockets];
    }

    public void setGem(int socketIndex, Gems gem) {
        if (socketIndex >= 0 && socketIndex < this.numberOfSockets.length) {
            this.numberOfSockets[socketIndex] = gem;
        }
    }

    public void removeGem(int socketIndex) {
        if (socketIndex >= 0 && socketIndex < this.numberOfSockets.length) {
            this.numberOfSockets[socketIndex] = null;
        }
    }

    public void calculateTheWeaponPoints(int constantMinDamage, int constantMaxDamage) {
        this.strength = 0;
        this.agility = 0;
        this.vitality = 0;

        for (Gems numberOfSocket : numberOfSockets) {
            if (numberOfSocket != null) {
                this.strength += numberOfSocket.getStrength();
                this.agility += numberOfSocket.getAgility();
                this.vitality += numberOfSocket.getVitality();
            }
        }

        int minDamage = (constantMinDamage + this.strength * 2)  + this.agility;
        int maxDamage = (constantMaxDamage + this.strength * 3) + this.agility * 4;

        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    public void calculateItemLevel(int constantMinDamage , int constantMaxDamage){
        this.calculateTheWeaponPoints(constantMinDamage,constantMaxDamage);
        this.itemLevel = ((double)(this.minDamage + this.maxDamage) / 2 + this.strength + this.agility + this.vitality);
    }

    public String printBiggerElement (Weapon weapon){
        StringBuilder builder = new StringBuilder();
        builder.append(weapon.toString() + String.format(" (Item Level: %.1f)",this.itemLevel));

        return builder.toString();
    }
    @Override
    public String toString() {
        return this.name+": "+this.minDamage+"-"+this.maxDamage+" Damage, +"+this.strength+" Strength, +"+this.agility+" Agility, +"+this.vitality+" Vitality";
    }

    @Override
    public int compareTo(Weapon o) {
        return Double.compare(this.itemLevel,o.itemLevel);
    }
}
