package FourthLectureEnumsAndAnnotations.CodingTracker;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tracker {

    private static Map<String, List<String>> map = new HashMap<>();

    @Author(name = "Pesho")
    public static void printMethodsByAuthor(Class<?> cl) {
        Method[] newClass = cl.getDeclaredMethods();
        for (Method aMethod : newClass) {
            Author newAuthor = aMethod.getAnnotation(Author.class);
            if (newAuthor != null) {
                if (map.containsKey(newAuthor.name())) {
                    map.get(newAuthor.name()).add(aMethod.getName());
                }
                else{
                    map.put(newAuthor.name(),new ArrayList<>());
                    map.get(newAuthor.name()).add(aMethod.getName());
                }
            }
        }
        for (Map.Entry<String, List<String>> stringListEntry : map.entrySet()) {
            System.out.println(stringListEntry.getKey() + ": " + String.join(", ",stringListEntry.getValue()));
        }
    }
}
