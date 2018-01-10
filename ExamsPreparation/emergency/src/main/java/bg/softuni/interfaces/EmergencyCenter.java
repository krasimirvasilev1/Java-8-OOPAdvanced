package bg.softuni.interfaces;

public interface EmergencyCenter {
    String getName();

    Integer getAmountOfMaximumEmergencies();

    Boolean isForRetirement();

    void addEmergency(Emergency emergency);
}
