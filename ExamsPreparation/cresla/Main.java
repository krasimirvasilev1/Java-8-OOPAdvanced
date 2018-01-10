package cresla;

import cresla.engine.Engine;
import cresla.interfaces.InputReader;
import cresla.interfaces.OutputWriter;
import cresla.io.ConsoleInputReader;
import cresla.io.ConsoleOutputReader;
import cresla.repository.Repository;
import cresla.repository.RepositoryImpl;

public class Main {
    public static void main(String[] args) {
        Repository repository = new RepositoryImpl();
        InputReader inputReader = new ConsoleInputReader();
        OutputWriter outputWriter = new ConsoleOutputReader();

        Engine engine = new Engine(repository,inputReader,outputWriter);

        engine.run();
    }
}
