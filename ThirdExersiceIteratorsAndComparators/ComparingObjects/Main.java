package ThirdExersiceIteratorsAndComparators.ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        List<Person> people = new ArrayList<>();
        while(true){
            String input = console.readLine();
            if (input.equalsIgnoreCase("End")){
                break;
            }
            String[] command = input.split("\\s+");
            Person person = new Person(command[0],Integer.parseInt(command[1]),command[2]);
            people.add(person);
        }

        int number = Integer.parseInt(console.readLine());
        Person newPerson = people.get(number - 1);

        int numberOfEqualPeople = 1;
        int numberOfNotEqualPeople = 0;
        for (int i = 0; i < people.size(); i++) {
            if (i == number - 1){
                continue;
            }
            if (newPerson.compareTo(people.get(i)) == 1){
                numberOfEqualPeople++;
            }
            else {
                numberOfNotEqualPeople++;
            }
        }

        if (numberOfEqualPeople == 1){
            System.out.println("No matches");
        }
        else {
            System.out.println(numberOfEqualPeople +" "+numberOfNotEqualPeople+" "+people.size());
        }
    }
}
