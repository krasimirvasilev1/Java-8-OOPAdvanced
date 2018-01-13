package SeventhExersiceOpenClosed.logger.interfaces;

import SeventhExersiceOpenClosed.logger.enums.ReportLevel;

public interface Appender {

    void setReportLevel(ReportLevel reportLevel);

    void messageAppended();

    ReportLevel getReportLevel();

    Layout getLayout();

    int getMessagesAppended();
}
