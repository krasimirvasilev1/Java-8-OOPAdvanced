package FifthLectureReflection.HighQualityMistakes;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Class newClass = Reflection.class;
        Field[] fields = newClass.getDeclaredFields();
        Method[] methods = newClass.getDeclaredMethods();

        Arrays.stream(fields).filter(x -> !Modifier.isPrivate(x.getModifiers())).sorted(Comparator.comparing(Field::getName)).forEach(x -> System.out.println(x.getName()+" must be private!"));

        Arrays.stream(methods).filter(x -> x.getName().startsWith("get")).filter(x -> !Modifier.isPublic(x.getModifiers())).sorted(Comparator.comparing(Method::getName)).forEach(x -> System.out.println(x.getName()+" have to be public!"));

        Arrays.stream(methods).filter(x -> x.getName().startsWith("set")).filter(x -> !Modifier.isPrivate(x.getModifiers())).sorted(Comparator.comparing(Method::getName)).forEach(x -> System.out.println(x.getName()+" have to be private!"));
    }
}
