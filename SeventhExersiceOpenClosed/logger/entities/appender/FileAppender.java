package SeventhExersiceOpenClosed.logger.entities.appender;

import SeventhExersiceOpenClosed.logger.enums.ReportLevel;
import SeventhExersiceOpenClosed.logger.interfaces.Layout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileAppender extends AppenderImpl {
    private int fileSize;

    public FileAppender(Layout layoutForAppender) {
        super(layoutForAppender);
    }

    public void increaseFileSize(String layoutMessage) {
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(layoutMessage);

        while (matcher.find()) {
            for (int i = 0; i < matcher.group().length(); i++) {
                this.fileSize += (int) matcher.group().charAt(i);
            }
        }
    }

    public int getFileSize() {
        return this.fileSize;
    }

    @Override
    public String toString() {
        return String.format("Appender type: File Appender, Layout type: %s, Report level: %s, Messages appended: %d, File size: %d",this.getLayout().getClass().getSimpleName(),this.getReportLevel().name(),this.getMessagesAppended(),this.getFileSize());
    }
}
