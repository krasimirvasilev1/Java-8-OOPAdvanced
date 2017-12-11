package FirstExersiceInterfaceAndAbstraction.Mood3;

public class Demon extends GameObjects {


    public Demon(String username, String hashedPassword, int level, double specialPoints) {
        super(username, hashedPassword, level, specialPoints);
    }

    @Override
    public void setHashedPassword(String hashedPassword) {
        hashedPassword(hashedPassword);
    }

    @Override
    public void hashedPassword(String hashedPassword) {
        super.setHashedPassword(String.valueOf(super.getUsername().length() * 217));
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("\"%s\"" + " | " + "\"%s\"" + " -> " + "%s%n", super.getUsername(), super.getHashedPassword(), "Archangel"));
        builder.append(String.format("%s", super.getSpecialPoints() * super.getLevel()));

        return builder.toString();
    }
}
