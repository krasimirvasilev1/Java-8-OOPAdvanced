package hell;

import hell.annotations.Inject;
import hell.interfaces.Executable;
import hell.interfaces.InputReader;
import hell.interfaces.OutputWriter;
import hell.io.ConsoleInputReader;
import hell.io.ConsoleOutputWriter;
import hell.repository.Repository;
import hell.repository.RepositoryImpl;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Engine {
    private static final String TERMINATE_COMMAND = "Quit";
    private static final String COMMAND_CLASS_PATH = "hell.commands.";
    private static final String COMMAND_CLASS_NAME_SUFFIX = "Command";

    private List<String> params;
    private InputReader reader;
    private OutputWriter writer;
    private Repository blobRepository;

    public Engine(InputReader inputReader, OutputWriter outputWriter , Repository repository) {
        this.reader = inputReader;
        this.writer = outputWriter;
        this.blobRepository = repository;
    }

    public void run(){
        while (true) {
            List<String> tokens = new ArrayList<>(Arrays.asList(this.reader.readLine().split("\\s+")));

            String debug = "";
            try {
                String result = this.dispatchCommand(tokens.get(0), tokens);
                if (result != null) {
                    this.writer.writeLine(result);
                }
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalStateException e) {
                this.writer.writeLine(e.getMessage());
            }

            if (TERMINATE_COMMAND.equals(tokens.get(0))) {
                break;
            }
        }
    }

    @SuppressWarnings("unchecked")
    private String dispatchCommand(String command, List<String> tokens) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        this.params = tokens;
        Class<Executable> commandClass = (Class<Executable>) Class.forName(COMMAND_CLASS_PATH + command + COMMAND_CLASS_NAME_SUFFIX);
        Constructor<Executable> constructor = commandClass.getDeclaredConstructor();
        Executable executable = constructor.newInstance();
        injectDependencies(executable);
        return executable.execute();
    }

    private void injectDependencies(Executable executable) throws IllegalAccessException {
        Field[] fieldsBaseCommand = executable.getClass().getSuperclass().getDeclaredFields();
        Field[] fieldsCommand = executable.getClass().getDeclaredFields();
        Field[] allFields = null;
        if (fieldsCommand.length > 0) {
            allFields = new Field[fieldsBaseCommand.length + fieldsCommand.length];
            System.arraycopy(fieldsBaseCommand, 0, allFields, 0, fieldsBaseCommand.length);
            System.arraycopy(fieldsCommand, 0, allFields, fieldsBaseCommand.length, fieldsCommand.length);
        }

        for (Field field : fieldsCommand.length > 0 ? allFields : fieldsBaseCommand) {
            if (field.isAnnotationPresent(Inject.class)) {
                Field[] currentFields = this.getClass().getDeclaredFields();
                for (Field currentField : currentFields) {
                    if (field.getType().equals(currentField.getType())) {
                        field.setAccessible(true);
                        field.set(executable, currentField.get(this));
                    }
                }
            }
        }
    }
}
