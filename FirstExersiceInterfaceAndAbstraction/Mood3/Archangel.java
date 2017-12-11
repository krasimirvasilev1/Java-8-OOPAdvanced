package FirstExersiceInterfaceAndAbstraction.Mood3;

public class Archangel extends GameObjects {
    public Archangel(String username, String hashedPassword, int level, double specialPoints) {
        super(username, hashedPassword, level, specialPoints);
    }

    @Override
    public void setHashedPassword(String hashedPassword) {
        hashedPassword(hashedPassword);
    }

    @Override
    public void hashedPassword(String hashedPassword) {
        StringBuilder builder = new StringBuilder(super.getUsername());
        builder.reverse();
        super.setHashedPassword(builder.toString() + super.getUsername().length() * 21);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("\"%s\""+" | "+"\"%s\""+" -> "+"%s%n",super.getUsername(),super.getHashedPassword(),"Archangel"));
        builder.append(String.format("%d",(int)(super.getSpecialPoints() * super.getLevel())));

        return builder.toString();
    }
}
