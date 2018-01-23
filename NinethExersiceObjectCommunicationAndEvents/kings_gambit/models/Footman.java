package NinethExersiceObjectCommunicationAndEvents.kings_gambit.models;

public class Footman extends Person {
    public Footman(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return String.format("Footman %s is panicking!",super.getName());
    }
}
