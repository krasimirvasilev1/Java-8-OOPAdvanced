package NinethLectureObjectCommunication.observer.models.hero;

import NinethLectureObjectCommunication.observer.interfaces.Observer;
import NinethLectureObjectCommunication.observer.interfaces.Subject;
import NinethLectureObjectCommunication.observer.interfaces.Target;

import java.util.ArrayList;
import java.util.List;

public class Dragon implements Target,Subject {

    private static final String THIS_DIED_EVENT = "%s dies";

    private String id;
    private int hp;
    private int reward;
    private boolean eventTriggered;
    List<Observer> observers;

    public Dragon(String id, int hp, int reward) {
        this.id = id;
        this.hp = hp;
        this.reward = reward;
        this.observers = new ArrayList<>();
    }

    @Override
    public void receiveDamage(int dmg) {
        if (!this.isDead()) {
            this.hp -= dmg;
        }

        if (this.isDead() && !eventTriggered) {
            System.out.println(String.format(THIS_DIED_EVENT, this));
            this.eventTriggered = true;
            this.notifyObservers();
        }
    }

    @Override
    public boolean isDead() {
        return this.hp <= 0;
    }

    @Override
    public String toString() {
        return this.id;
    }

    @Override
    public void register(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this.reward);
        }
    }
}
