package app.models.participants;

import app.contracts.Targetable;
import app.models.Config;

public class Boss implements Targetable {
    private String name;
    private double health;
    private double damage;
    private double gold;
    private boolean isAlive;

    public Boss() {
        this.setName(Config.BOSS_NAME);
        this.setHealth(Config.BOSS_HEALTH);
        this.setDamage(Config.BOSS_DAMAGE);
        this.setGold(Config.BOSS_GOLD);
        this.setAlive(true);
    }


    private void setDamage(double damage) {
        this.damage = damage;
    }

    private void setGold(double gold) {
        this.gold = gold;
    }

    private void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public String attack(Targetable target) {
        if (!this.isAlive()) {
            return this.getName() + " is dead! Cannot attack.";
        }

        if (!target.isAlive()){
            return target.getName() + " is dead! Cannot be attacked.";
        }

        target.takeDamage(this.getDamage());

        String result = this.getName() + " attacked!";
        if (!target.isAlive()) {
            target.giveReward(this);
            result += String.format(" %s has been slain by %s.", target.getName(), this.getName());
        }
        return result;
    }

    @Override
    public void takeDamage(double damage) {
        this.setHealth(this.getHealth() - damage);
        if (this.getHealth() <= 0){
            this.setAlive(false);
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getDamage() {
        return this.damage;
    }

    @Override
    public double getHealth() {
        return this.health;
    }

    @Override
    public double getGold() {
        return this.gold;
    }

    @Override
    public void setHealth(double health) {
        this.health = health;
    }

    @Override
    public void giveReward(Targetable targetable) {
        targetable.receiveReward(this.gold);
        this.gold = 0;
    }

    @Override
    public void receiveReward(double reward) {
        this.gold += reward;
    }

    @Override
    public void levelUp() {
        this.setHealth(Config.BOSS_HEALTH);
    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("  Name: %s | Class: %s%n", this.getName(), this.getClass().getSimpleName()));
        sb.append(String.format("  Health: %.2f | Damage: %.2f | Gold: %.2f", this.getHealth(), this.getDamage(), this.getGold()));

        return sb.toString();
    }
}
