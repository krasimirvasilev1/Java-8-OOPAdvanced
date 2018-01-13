package SeventhExersiceOpenClosed.logger.entities.appender;

import SeventhExersiceOpenClosed.logger.enums.ReportLevel;
import SeventhExersiceOpenClosed.logger.interfaces.Appender;
import SeventhExersiceOpenClosed.logger.interfaces.Layout;

public abstract class AppenderImpl implements Appender {
    private Layout layout;
    private ReportLevel reportLevel;
    private int messagesAppended;

    public AppenderImpl(Layout layoutForAppender) {
        this.layout = layoutForAppender;
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    @Override
    public ReportLevel getReportLevel() {
        return this.reportLevel;
    }

    @Override
    public void messageAppended() {
        this.messagesAppended += 1;
    }

    @Override
    public Layout getLayout() {
        return this.layout;
    }

    @Override
    public int getMessagesAppended() {
        return this.messagesAppended;
    }
}
