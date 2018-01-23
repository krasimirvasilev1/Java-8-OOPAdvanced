package NinethExersiceObjectCommunicationAndEvents.event_implementation.interfaces;

import NinethExersiceObjectCommunicationAndEvents.event_implementation.models.NameChange;

public interface NameChangeListener {

    void handleChangedName(NameChange nameChange);
}
