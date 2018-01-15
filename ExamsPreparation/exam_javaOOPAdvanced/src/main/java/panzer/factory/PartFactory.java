package panzer.factory;

import panzer.contracts.Part;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class PartFactory {
    private static final String PART_CLASS_PATH = "panzer.models.parts.";
    private static final String PART_SUFFIX = "Part";

    public Part create(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class<?> participantClass = Class.forName(PART_CLASS_PATH + className + PART_SUFFIX);
        Constructor<?> declaredConstructor = participantClass.getDeclaredConstructor();
        Part part = (Part) declaredConstructor.newInstance();

        return part;
    }
}
