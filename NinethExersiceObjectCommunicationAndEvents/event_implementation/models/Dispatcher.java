package NinethExersiceObjectCommunicationAndEvents.event_implementation.models;

import NinethExersiceObjectCommunicationAndEvents.event_implementation.interfaces.NameChangeListener;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {
    private String name;
    private Handler handler;
    private List<NameChangeListener> changeListeners;

    public Dispatcher(String name, Handler handler) {
        this.name = name;
        this.handler = handler;
        this.changeListeners = new ArrayList<>();
    }

    public void addNameChangeListener(NameChangeListener nameChangeListener) {
        this.changeListeners.add(nameChangeListener);
    }

    public void removeNameChangeListener(NameChangeListener nameChangeListener) {
        if (this.changeListeners.contains(nameChangeListener)) {
            this.changeListeners.remove(nameChangeListener);
        }
    }

    public void fireNameChangeEvent(NameChange nameChange) {
        for (NameChangeListener changeListener : changeListeners) {
            changeListener.handleChangedName(nameChange);
        }

    }
}