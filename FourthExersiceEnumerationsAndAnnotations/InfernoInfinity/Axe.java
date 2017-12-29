package FourthExersiceEnumerationsAndAnnotations.InfernoInfinity;

public class Axe extends Weapon {
    public Axe(String name) {
        super(name);
    }

    @Override
    public void setMinDamage(int minDamage) {
        super.setMinDamage(5);
    }

    @Override
    public void setMaxDamage(int maxDamage) {
        super.setMaxDamage(10);
    }

    @Override
    public void setNumberOfSockets(int numberOfSockets) {
        super.setNumberOfSockets(4);
    }

}
