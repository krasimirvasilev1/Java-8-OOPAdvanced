package SeventhExersiceOpenClosed.logger.entities.appender;

import SeventhExersiceOpenClosed.logger.interfaces.Layout;

public class ConsoleAppender extends AppenderImpl {

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public String toString() {
        String layoutType = this.getLayout().getClass().getSimpleName();
            return String.format("Appender type: ConsoleAppender, Layout type: %s, Report level: %s, Messages appended: %d",layoutType, this.getReportLevel().name(), this.getMessagesAppended());
    }
}
