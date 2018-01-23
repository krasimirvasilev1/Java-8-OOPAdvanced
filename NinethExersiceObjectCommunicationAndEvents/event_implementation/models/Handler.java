package NinethExersiceObjectCommunicationAndEvents.event_implementation.models;

import NinethExersiceObjectCommunicationAndEvents.event_implementation.interfaces.NameChangeListener;

public class Handler implements NameChangeListener {

    @Override
    public void handleChangedName(NameChange nameChangeListener) {
        System.out.printf("Dispatcher's name changed to %s.%n",nameChangeListener.getChangedName());
    }

}
