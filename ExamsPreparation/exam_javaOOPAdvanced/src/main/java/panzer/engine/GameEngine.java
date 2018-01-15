package panzer.engine;

import panzer.handlers.CommandHandlerImpl;
import panzer.contracts.InputReader;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class GameEngine {
    private static final String TERMINATE_COMMAND = "Terminate";

    private InputReader reader;
    private CommandHandlerImpl commandHandler;

    public GameEngine(InputReader reader, CommandHandlerImpl handler) {
        this.reader = reader;
        this.commandHandler = handler;
    }

    public void run() throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        String line;
        while (true){
            line = this.reader.readLine();
            String[] lineTokens = line.split("\\s+");

            this.commandHandler.executeCommand(lineTokens[0], Arrays.stream(lineTokens).skip(1).collect(Collectors.toList()));
            if (TERMINATE_COMMAND.equals(line)) {
                break;
            }
        }
    }
}
