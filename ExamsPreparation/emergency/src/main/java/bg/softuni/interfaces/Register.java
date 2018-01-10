package bg.softuni.interfaces;

import bg.softuni.models.emergency.EmergencyImpl;

public interface Register extends Cloneable{

    void enqueueEmergency(Emergency emergency);

    Emergency dequeueEmergency();

    Emergency peekEmergency();

    Boolean isEmpty();

    Object clone();
}
