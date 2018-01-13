package SeventhExersiceOpenClosed.logger.engine;

import SeventhExersiceOpenClosed.logger.entities.appender.FileAppender;
import SeventhExersiceOpenClosed.logger.enums.ReportLevel;
import SeventhExersiceOpenClosed.logger.interfaces.Appender;
import SeventhExersiceOpenClosed.logger.interfaces.InputReader;
import SeventhExersiceOpenClosed.logger.interfaces.Layout;
import SeventhExersiceOpenClosed.logger.interfaces.OutputWriter;
import SeventhExersiceOpenClosed.logger.repositories.Repository;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Engine implements Runnable {

    private final String PATH_TO_APPENDER_CLASS = "SeventhExersiceOpenClosed.NinethLectureObjectCommunication.logger.entities.appender.";
    private final String PATH_TO_LAYOUT_CLASS = "SeventhExersiceOpenClosed.NinethLectureObjectCommunication.logger.entities.layout.";

    private InputReader reader;
    private OutputWriter writer;
    private Repository repository;

    public Engine(InputReader reader, OutputWriter writer, Repository repository) {
        this.reader = reader;
        this.writer = writer;
        this.repository = repository;
    }


    @Override
    public void run() {
        int numberOfRotations = Integer.parseInt(this.reader.readLine());
        try {
            addAppendersToRepository(numberOfRotations);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        while (true) {
            String input = this.reader.readLine();
            if (input.equalsIgnoreCase("END")) {
                break;
            }
            List<String> tokens = new ArrayList<>(Arrays.asList(input.split("\\|")));
            readMessagesAndProcess(tokens);

        }

        System.out.println("Logger info");
            for (String typeAppender : this.repository.getRepository().keySet()) {
                for (Appender appender : this.repository.getListOfAppenders(typeAppender)) {
                    System.out.println(appender);
                }
            }
        }

    private void readMessagesAndProcess(List<String> tokens) {
        for (String appenderName : this.repository.getRepository().keySet()) {
            for (Appender appender : this.repository.getListOfAppenders(appenderName)) {
                if (appender.getReportLevel().ordinal() <= ReportLevel.valueOf(tokens.get(0).toUpperCase()).ordinal()) {
                    if (appenderName.equalsIgnoreCase("ConsoleAppender")) {
                        System.out.println(String.format(appender.getLayout().formatMessage(), tokens.get(1), tokens.get(0), tokens.get(2)));
                        appender.messageAppended();
                    } else if (appenderName.equalsIgnoreCase("FileAppender")){
                        FileAppender fileAppender = (FileAppender) appender;
                        fileAppender.increaseFileSize(String.format(fileAppender.getLayout().formatMessage(), tokens.get(1), tokens.get(0), tokens.get(2)));
                        appender.messageAppended();
                    }
                }
            }
        }
    }

    private void addAppendersToRepository(int numberOfRotations) throws ClassNotFoundException {
        for (int i = 0; i < numberOfRotations; i++) {
            List<String> tokens = new ArrayList<>(Arrays.asList(this.reader.readLine().split("\\s+")));
            Appender appender = null;
            Class newAppenderClass = Class.forName(PATH_TO_APPENDER_CLASS + tokens.get(0));
            Constructor constructor = null;
            try {
                constructor = newAppenderClass.getDeclaredConstructor(Layout.class);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            constructor.setAccessible(true);
            Class newLayoutClass = Class.forName(PATH_TO_LAYOUT_CLASS + tokens.get(1));
            try {
                appender = (Appender) constructor.newInstance(newLayoutClass.newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            if (tokens.size() == 2) {
                appender.setReportLevel(ReportLevel.INFO);
            } else {
                appender.setReportLevel(ReportLevel.valueOf(tokens.get(2).toUpperCase()));
            }

            this.repository.addAppender(appender);
        }
    }
}