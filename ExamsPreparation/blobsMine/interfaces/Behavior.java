package blobsMine.interfaces;


public interface Behavior {

    boolean isTriggered();

    void setIsTriggered(boolean isTriggered);

    boolean toDelayRecurrentEffect();

    void setToDelayRecurrentEffect(boolean toDelayRecurrentEffect);

    void trigger(Blob source);

    void applyRecurrentEffect(Blob source);
}
