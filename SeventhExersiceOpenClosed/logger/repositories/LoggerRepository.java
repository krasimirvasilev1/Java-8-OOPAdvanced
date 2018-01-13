package SeventhExersiceOpenClosed.logger.repositories;

import SeventhExersiceOpenClosed.logger.interfaces.Appender;

import java.util.*;

public class LoggerRepository implements Repository {
    private Map<String, List<Appender>> appenders;

    public LoggerRepository() {
        this.appenders = new LinkedHashMap<>();
    }

    @Override
    public void addAppender(Appender appender) {
        if (this.appenders.containsKey(appender.getClass().getSimpleName())) {
            this.appenders.get(appender.getClass().getSimpleName()).add(appender);
        }
        else{
            this.appenders.put(appender.getClass().getSimpleName(), new ArrayList<>());
            this.appenders.get(appender.getClass().getSimpleName()).add(appender);
        }
    }

    @Override
    public Map<String, List<Appender>> getRepository() {
        return this.appenders;
    }

    @Override
    public List<Appender> getListOfAppenders(String appenderName) {
        return this.appenders.get(appenderName);
    }
}
