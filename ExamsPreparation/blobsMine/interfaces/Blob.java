package blobsMine.interfaces;

public interface Blob {

    int getHealth();

    void setHealth(int health);

    int getDamage();

    void setDamage(int currentDamage);

    Behavior getBehavior();

    String getName();

    void attack(Blob target);

    void respond(int damage);

    void update();

    int getInitialHealth();

    void triggerBehavior();

    //   void attach(Observer NinethLectureObjectCommunication.observer);
}
