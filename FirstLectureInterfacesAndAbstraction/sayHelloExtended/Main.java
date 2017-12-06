package FirstLectureInterfacesAndAbstraction.sayHelloExtended;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();

        personList.add(new Bulgarian("Pesho"));
        personList.add(new European("Pesho"));
        personList.add(new Chinese("Pesho"));

        for (Person person : personList) {
            print(person);
        }
    }

    private static void print(Person person) {
        System.out.println(person.sayHello());
    }
}
