package FourthLectureEnumsAndAnnotations.WarningLevels;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private Importance importance;
    private List<Message> messages;


    public Logger(Importance importance) {
        this.importance = importance;
        this.messages = new ArrayList<>();
    }

    public void messageChecker(Importance importance , String message){
        Message message1 = new Message(importance.toString()+": "+message);
        if (this.importance.getValue() <= importance.getValue()){
            this.messages.add(message1);
        }
    }

    public Iterable<Message> iterator() {
        return this.messages;
    }
}
