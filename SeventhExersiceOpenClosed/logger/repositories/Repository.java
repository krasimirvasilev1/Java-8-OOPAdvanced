package SeventhExersiceOpenClosed.logger.repositories;

import SeventhExersiceOpenClosed.logger.interfaces.Appender;

import java.util.List;
import java.util.Map;


public interface Repository {

    void addAppender(Appender appender);

    Map<String,List<Appender>> getRepository();

    List<Appender> getListOfAppenders(String appenderName);
}
