package bg.softuni.models.emergency;

import bg.softuni.enums.EmergencyLevel;
import bg.softuni.interfaces.RegistrationTime;

public class PublicOrderEmergency extends EmergencyImpl {
    private boolean specialCase;

    public PublicOrderEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, String specialCase) {
        super(description, emergencyLevel, registrationTime);
        setSpecialCase(specialCase);
    }

    private void setSpecialCase(String specialCase) {
        if ("Special".equalsIgnoreCase(specialCase)){
            this.specialCase = true;
        }
        else{
            this.specialCase = false;
        }
    }

    public boolean isSpecialCase() {
        return this.specialCase;
    }
}
