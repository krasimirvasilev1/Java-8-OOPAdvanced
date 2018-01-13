package SeventhExersiceOpenClosed.logger;


import SeventhExersiceOpenClosed.logger.engine.Engine;
import SeventhExersiceOpenClosed.logger.interfaces.InputReader;
import SeventhExersiceOpenClosed.logger.interfaces.OutputWriter;
import SeventhExersiceOpenClosed.logger.io.ConsoleInputReader;
import SeventhExersiceOpenClosed.logger.io.ConsoleOutputWriter;
import SeventhExersiceOpenClosed.logger.repositories.LoggerRepository;
import SeventhExersiceOpenClosed.logger.repositories.Repository;


public class Main {
    public static void main(String[] args) {
        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();
        Repository repository = new LoggerRepository();
        Runnable engine = new Engine(reader, writer, repository);
        engine.run();
    }
}
