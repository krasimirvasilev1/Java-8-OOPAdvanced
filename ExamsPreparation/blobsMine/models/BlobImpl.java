package blobsMine.models;

import blobsMine.interfaces.Attack;
import blobsMine.interfaces.Behavior;
import blobsMine.interfaces.Blob;
import blobsMine.models.attacks.PutridFart;
import blobsMine.models.behavors.Aggressive;
import blobsMine.models.behavors.Inflated;

public class BlobImpl implements Blob{

    private String name;
    private int currentHealth;
    private int damage;
    private Behavior behavior;
    private Attack attack;
    private int triggerCount;
    private int initialHealth;
    private int initialDamage;

    public BlobImpl(String name, int health, int damage, Behavior behavior, Attack attack) {
        this.name = name;
        this.currentHealth = health;
        this.damage = damage;
        this.behavior = behavior;
        this.attack = attack;

        this.initialHealth = health;
        this.initialDamage = damage;
    }

    public int getHealth() {
        return this.currentHealth;
    }

    @Override
    public int getInitialHealth() {
        return this.initialHealth;
    }

    public void setHealth(int health) {
        this.currentHealth = health;

        if (this.currentHealth < 0) {
            this.currentHealth = 0;
        }

        if (this.currentHealth <= this.initialHealth / 2 && !this.behavior.isTriggered()) {
            this.triggerBehavior();
        }
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int currentDamage) {
        this.damage = currentDamage;
    }

    public void attack(Blob target) {
        this.attack.execute(this,target);
    }

    @Override
    public void respond(int damage) {
        int currentHealth = this.getHealth();
        currentHealth -= damage;
        this.setHealth(currentHealth);
    }

    public void triggerBehavior() {
        if (this.behavior instanceof Aggressive) {
            if (this.behavior.isTriggered()) {
                ((Aggressive) this.behavior).setIsTriggered(true);
                this.applyAgressiveTriggerEffect();
            }
        }
        else if (this.behavior instanceof Inflated) {
            if (this.behavior.isTriggered()) {
                ((Inflated) this.behavior).setIsTriggered(true);
                this.applyInflatedTriggerEffect();
            }
        }
    }

    public Behavior getBehavior() {
        return this.behavior;
    }

    public String getName() {
        return this.name;
    }

    public void update() {
        if (this.behavior.isTriggered()) {
            if (this.behavior instanceof Aggressive) {
                if (this.behavior.isTriggered()) {
                    ((Aggressive) this.behavior).setIsTriggered(true);
                    this.applyAgressiveRecurrentEffect();
                }
            }
        }
    }

//    @Override
//    public void attach(Observer NinethLectureObjectCommunication.observer) {
//
//    }

    @Override
    public String toString() {
        if (this.getHealth() <= 0) {
            return String.format("IBlob %s KILLED", this.getName());
        }

        return String.format("IBlob %s: %s HP, %s Damage", this.getName(), this.getHealth(), this.getDamage());
    }

    private void attackAffectSource(Blob source) {
        source.setHealth(source.getHealth() - source.getHealth() / 2);
    }

    private void attackAffectTarget(Blob source, Blob target) {
        target.respond(source.getDamage() * 2);
    }

    private void applyAgressiveTriggerEffect() {
        this.setDamage(this.getDamage() * 2);
    }

    private void applyInflatedTriggerEffect(){
        this.setHealth(this.getHealth() + 50);
    }

    private void applyAgressiveRecurrentEffect() {
        if (((Aggressive)this.behavior).toDelayRecurrentEffect()) {
            ((Aggressive)this.behavior).setToDelayRecurrentEffect(false);
        } else {
            this.setDamage(this.getDamage() - 5);

            if (this.getDamage() <= this.initialHealth) {
                this.setDamage(this.initialDamage);
            }
        }
    }
}
