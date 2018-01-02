package FifthExersiceReflection.pr02PrivateClassFiddling;


import FifthExersiceReflection.pr02PrivateClassFiddling.com.peshoslav.BlackBoxInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, IOException, NoSuchFieldException {
	    BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        Class classForUse = BlackBoxInt.class;
        Constructor constructor = classForUse.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt newObject = (BlackBoxInt) constructor.newInstance();

        while(true){
            String input = console.readLine();
            if (input.equalsIgnoreCase("end")){
                break;
            }

            String[] commands = input.split("_");
            Method method = newObject.getClass().getDeclaredMethod(commands[0],int.class);
            method.setAccessible(true);
            method.invoke(newObject,Integer.parseInt(commands[1]));

            Field field = newObject.getClass().getDeclaredField("innerValue");
            field.setAccessible(true);
            System.out.println(field.getInt(newObject));
        }
	}
}
