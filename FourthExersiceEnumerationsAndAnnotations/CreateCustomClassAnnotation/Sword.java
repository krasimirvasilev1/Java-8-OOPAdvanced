package FourthExersiceEnumerationsAndAnnotations.CreateCustomClassAnnotation;

public class Sword extends Weapon {
    public Sword(String name) {
        super(name);
    }

    @Override
    public void setMinDamage(int minDamage) {
        super.setMinDamage(4);
    }

    @Override
    public void setMaxDamage(int maxDamage) {
        super.setMaxDamage(6);
    }

    @Override
    public void setNumberOfSockets(int numberOfSockets) {
        super.setNumberOfSockets(3);
    }
}
