package bg.softuni.models.emergency;

import bg.softuni.enums.EmergencyLevel;
import bg.softuni.interfaces.RegistrationTime;

public class PublicPropertyEmergency extends EmergencyImpl {
    private int damage;

    public PublicPropertyEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, int damage) {
        super(description, emergencyLevel, registrationTime);
        this.damage = damage;
    }

    public int getDamage() {
        return this.damage;
    }
}
