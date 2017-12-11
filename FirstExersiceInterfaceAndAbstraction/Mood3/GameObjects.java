package FirstExersiceInterfaceAndAbstraction.Mood3;

import java.util.HashMap;

public abstract class GameObjects implements HashedPassword {
    private String username;
    private String hashedPassword;
    private int level;
    private double specialPoints;

    protected GameObjects(String username, String hashedPassword, int level,double specialPoints) {
        this.username = username;
        setHashedPassword(hashedPassword);
        this.level = level;
        this.specialPoints = specialPoints;
    }

    public String getUsername() {
        return username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public int getLevel() {
        return level;
    }

    public double getSpecialPoints() {
        return specialPoints;
    }

    public void setHashedPassword(String hashedPassword){
        this.hashedPassword = hashedPassword;
    }

}
