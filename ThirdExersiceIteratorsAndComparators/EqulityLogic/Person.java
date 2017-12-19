package ThirdExersiceIteratorsAndComparators.EqulityLogic;


public class Person extends Object{

    private String name;
    private Integer age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals (Object a){
        Person newPerson = (Person)a;
        if ((newPerson.getName().compareTo(this.name) == 0) && Integer.compare(newPerson.getAge(),this.age) == 0){
            return true;
        }
        else {
            return false;
        }
    }

    public int hashCode(){
        return this.name.hashCode() * this.age.hashCode();
    }


}
