package blobsMine;

import blobsMine.engine.Engine;
import blobsMine.interfaces.InputReader;
import blobsMine.interfaces.OutputReader;
import blobsMine.io.ConsoleInputReader;
import blobsMine.io.ConsoleOutputWriter;
import blobsMine.repository.BlobRepository;
import blobsMine.repository.Repository;
import blobsMine.interfaces.Blob;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Repository<Blob> repository = new BlobRepository<>();
        InputReader inputReader = new ConsoleInputReader();
        OutputReader outputReader = new ConsoleOutputWriter();

        Engine engine = new Engine(repository,inputReader,outputReader);

        engine.run();
    }
}
