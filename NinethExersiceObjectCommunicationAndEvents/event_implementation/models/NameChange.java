package NinethExersiceObjectCommunicationAndEvents.event_implementation.models;

public class NameChange {
    private String changedName;

    public NameChange(String changedName) {
        this.changedName = changedName;
    }

    public String getChangedName() {
        return this.changedName;
    }
}
