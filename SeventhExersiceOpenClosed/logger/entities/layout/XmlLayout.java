package SeventhExersiceOpenClosed.logger.entities.layout;

public class XmlLayout extends LayoutImpl{

    @Override
    public String formatMessage() {
        StringBuilder builder = new StringBuilder();
        builder.append("<log>%n    <date>%s</date>%n    <level>%s</level>%n    <message>%s</message>%n</log>");
        return builder.toString();
    }
}
