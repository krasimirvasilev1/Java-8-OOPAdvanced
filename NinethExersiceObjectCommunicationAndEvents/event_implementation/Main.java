package NinethExersiceObjectCommunicationAndEvents.event_implementation;

import NinethExersiceObjectCommunicationAndEvents.event_implementation.models.Dispatcher;
import NinethExersiceObjectCommunicationAndEvents.event_implementation.models.Handler;
import NinethExersiceObjectCommunicationAndEvents.event_implementation.models.NameChange;
//import NinethExersiceObjectCommunicationAndEvents.event_implementation.models.NameChange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Handler handler = new Handler();
        Dispatcher dispatcher = new Dispatcher("krasi", handler);
        dispatcher.addNameChangeListener(handler);
        while (true) {
            String input = console.readLine();
            if (input.equalsIgnoreCase("End")) {
                break;
            }

            dispatcher.fireNameChangeEvent(new NameChange(input));

        }
    }
}
