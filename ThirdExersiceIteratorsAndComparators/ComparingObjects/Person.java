package ThirdExersiceIteratorsAndComparators.ComparingObjects;

public class Person implements Comparable<Person> {
    String name;
    int age;
    String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }



    @Override
    public int compareTo(Person o) {
        if (this.name.compareTo(o.name) == 0 && Integer.compare(this.age,o.age) == 0 && this.town.compareTo(o.town) == 0){
            return 1;
        }
        else {
            return -1;
        }
    }
}
