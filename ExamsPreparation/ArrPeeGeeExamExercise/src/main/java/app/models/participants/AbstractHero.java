package app.models.participants;

import app.contracts.Hero;
import app.contracts.Targetable;
import app.models.Config;

public abstract class AbstractHero implements Hero{
    private String name;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int level;
    private double health;
    private int damage;
    private double gold;
    private boolean isAlive;

    protected AbstractHero() {
        this.setAlive(true);
        this.level = 1;
        this.setGold(Config.HERO_START_GOLD);
    }

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
            this.levelUp();
            target.giveReward(this);
            result += String.format(" %s has been slain by %s.", target.getName(), this.getName());
        }

        return result;
    }

    public double getReward(){
        this.gold = 0;
        return this.gold;
    }

    public void receiveReward(double reward){
        this.gold += reward;
    }

    public void takeDamage(double damage) {
        this.setHealth(this.getHealth() - damage);
        if (this.getHealth() <= 0){
            this.setAlive(false);
        }
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
        this.setHealth(strength * Config.HERO_HEALTH_MULTIPLIER);
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        if (health < 0) {
            health = 0;
        }

        if (health > this.getStrength() * Config.HERO_HEALTH_MULTIPLIER) {
            health = this.getStrength() * Config.HERO_HEALTH_MULTIPLIER;
        }

        this.health = health;
    }

    @Override
    public void giveReward(Targetable targetable) {
        targetable.receiveReward(this.gold);
        this.gold = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDamage() {
        return (this.getStrength() * 2) + this.getDexterity();
    }

    public double getGold() {
        return this.gold;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setGold(double gold) {
        this.gold = gold;
    }

    public int getLevel() {
        return this.level;
    }

    public void levelUp() {
        this.setHealth(this.getStrength() * Config.HERO_HEALTH_MULTIPLIER);
        this.setStrength(this.getStrength() * 2);
        this.setDexterity(this.getDexterity() * 2);
        this.setIntelligence(this.getIntelligence() * 2);
        this.level += 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("  Name: %s | Class: %s", this.getName(), this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("  Health: %.2f | Damage: %.2f", this.getHealth(), this.getDamage()))
                .append(System.lineSeparator())
                .append(String.format("  %d STR | %d DEX | %d INT | %.2f Gold", this.getStrength(), this.getDexterity(), this.getIntelligence(), this.gold));

        return sb.toString();
    }
}
