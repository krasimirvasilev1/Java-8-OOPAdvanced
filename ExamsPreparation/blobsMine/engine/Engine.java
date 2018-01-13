package blobsMine.engine;


import blobsMine.interfaces.Blob;
import blobsMine.interfaces.Executable;
import blobsMine.interfaces.InputReader;
import blobsMine.interfaces.OutputReader;
import blobsMine.repository.Repository;
import blobsMine.annotations.Inject;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine {

    private final String CLASS_DIRECTORY = "blobsMine.core.commands.";
    private final String CLASS_SUFFIX = "NinethLectureObjectCommunication/command";

    private Repository<Blob> repository;
    private InputReader inputReader;
    private OutputReader outputWriter;
    private List<String> params;

    public Engine(Repository<Blob> repository, InputReader inputReader, OutputReader outputWriter) {
        this.repository = repository;
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
    }

    public void run() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        while (true) {
            String line = this.inputReader.readLine();
            if ("drop".equalsIgnoreCase(line)) {
                break;
            }
            this.params = Arrays.stream(line.split("\\s+")).collect(Collectors.toList());
            String result = this.dispatchCommand(this.params);
            if (result != null){
                System.out.println(result);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private String dispatchCommand(List<String> inputLine) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String classPath = CLASS_DIRECTORY + String.valueOf(inputLine.get(0).charAt(0)).toUpperCase() + inputLine.get(0).substring(1) + CLASS_SUFFIX;
        Class<Executable> newClass = (Class<Executable>)Class.forName(classPath);
        Constructor <Executable> constructor = newClass.getDeclaredConstructor();
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
