package ThirdExersiceIteratorsAndComparators.StrategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<Person> treeSet1 = new TreeSet<>(new ComparatorName());
        TreeSet<Person> treeSet2 = new TreeSet<>(new ComparatorAge());

        int numberOfPeople = Integer.parseInt(console.readLine());
        for (int i = 0; i < numberOfPeople; i++) {
            String[] input = console.readLine().split("\\s+");
            Person person = new Person(input[0],Integer.parseInt(input[1]));
            treeSet1.add(person);
            treeSet2.add(person);
        }

        for (Person person : treeSet1) {
            System.out.println(person.getName() + " "+ person.getAge());
        }

        for (Person person : treeSet2) {
            System.out.println(person.getName()+" "+person.getAge());
        }
    }
}
