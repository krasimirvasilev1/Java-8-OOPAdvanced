package NinethExersiceObjectCommunicationAndEvents.kings_gambit.models;

public class RoyalGuard extends Person {
    public RoyalGuard(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return String.format("Royal Guard %s is defending!",super.getName());
    }
}
