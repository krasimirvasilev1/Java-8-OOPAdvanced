package panzer.factory;

import panzer.contracts.Part;
import panzer.contracts.Vehicle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class VechicleFactory {
    private static final String PART_CLASS_PATH = "panzer.models.vehicles.";

    public Vehicle create(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class<?> participantClass = Class.forName(PART_CLASS_PATH + className);
        Constructor<?> declaredConstructor = participantClass.getDeclaredConstructor();
        Vehicle vehicle = (Vehicle) declaredConstructor.newInstance();

        return vehicle;
    }
}
