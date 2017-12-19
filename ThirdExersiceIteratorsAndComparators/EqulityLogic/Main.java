package ThirdExersiceIteratorsAndComparators.EqulityLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Person> set1 = new TreeSet<>(new ComparatorForAll());
        HashSet<Person> set = new HashSet<>();

       int numberOfPeople = Integer.parseInt(console.readLine());
        for (int i = 0; i < numberOfPeople; i++) {
            String[] input = console.readLine().split("\\s+");
            Person person = new Person(input[0],Integer.parseInt(input[1]));
            set.add(person);
            set1.add(person);
        }

        System.out.println(set.size());
        System.out.println(set1.size());
    }
}
