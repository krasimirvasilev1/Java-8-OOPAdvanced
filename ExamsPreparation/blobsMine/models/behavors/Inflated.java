package blobsMine.models.behavors;

import blobsMine.interfaces.Blob;
import blobsMine.models.BlobImpl;

public class Inflated extends AbstractBehavior {
    private static final int INFLATED_HEALTH_INCREASE = 50;
    private static final int INFLATED_HEALTH_DECREMENT = 10;

    private int sourceInitialHealth;

    @Override
    public void trigger(Blob source) {
        this.sourceInitialHealth = source.getHealth();
        super.setIsTriggered(true);
        this.applyTriggerEffect(source);
    }

    @Override
    public void applyRecurrentEffect(Blob source) {
        if (super.toDelayRecurrentEffect()) {
            super.setToDelayRecurrentEffect(false);
        } else {
            source.setHealth(source.getHealth() - INFLATED_HEALTH_DECREMENT);

            if (source.getDamage() <= this.sourceInitialHealth) {
                source.setDamage(this.sourceInitialHealth);
            }
        }
    }

    private void applyTriggerEffect (Blob source){
        source.setHealth(source.getHealth() + INFLATED_HEALTH_INCREASE);
    }
}
