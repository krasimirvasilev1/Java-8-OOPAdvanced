package bg.softuni.models.emergency;

import bg.softuni.enums.EmergencyLevel;
import bg.softuni.interfaces.Emergency;
import bg.softuni.interfaces.RegistrationTime;

public abstract class EmergencyImpl implements Emergency {
    private String description;

    private EmergencyLevel emergencyLevel;

    private RegistrationTime registrationTime;

    protected EmergencyImpl(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime) {
        this.description = description;
        this.emergencyLevel = emergencyLevel;
        this.registrationTime = registrationTime;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public EmergencyLevel getEmergencyLevel() {
        return this.emergencyLevel;
    }

    @Override
    public RegistrationTime getRegistrationTimeImpl() {
        return this.registrationTime;
    }
}
