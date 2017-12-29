package FourthExersiceEnumerationsAndAnnotations.InfernoInfinity;

public class Knife extends  Weapon{
    public Knife(String name) {
        super(name);
    }

    @Override
    public void setMinDamage(int minDamage) {
        super.setMinDamage(3);
    }

    @Override
    public void setMaxDamage(int maxDamage) {
        super.setMaxDamage(4);
    }

    @Override
    public void setNumberOfSockets(int numberOfSockets) {
        super.setNumberOfSockets(2);
    }
}
