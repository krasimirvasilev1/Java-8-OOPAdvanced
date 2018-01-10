package hell;

import hell.interfaces.InputReader;
import hell.interfaces.OutputWriter;
import hell.io.ConsoleInputReader;
import hell.io.ConsoleOutputWriter;
import hell.repository.Repository;
import hell.repository.RepositoryImpl;

public class Main {
    public static void main(String[] args){
        InputReader inputReader = new ConsoleInputReader();
        OutputWriter outputWriter = new ConsoleOutputWriter();
        Repository repository = new RepositoryImpl();

        Engine engine = new Engine(inputReader,outputWriter,repository);

        engine.run();
    }
}