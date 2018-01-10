package bg.softuni.interfaces;

import bg.softuni.enums.EmergencyLevel;

public interface Emergency {
    String getDescription();

    EmergencyLevel getEmergencyLevel();

    RegistrationTime getRegistrationTimeImpl();
}
