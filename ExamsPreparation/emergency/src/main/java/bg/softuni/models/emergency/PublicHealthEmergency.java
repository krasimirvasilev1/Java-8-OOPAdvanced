package bg.softuni.models.emergency;

import bg.softuni.enums.EmergencyLevel;
import bg.softuni.interfaces.RegistrationTime;

public class PublicHealthEmergency extends EmergencyImpl {
    private int numberOfCasualties;

    public PublicHealthEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, int numberOfCasualties) {
        super(description, emergencyLevel, registrationTime);
        this.numberOfCasualties = numberOfCasualties;
    }

    public int getNumberOfCasulties() {
        return this.numberOfCasualties;
    }
}
