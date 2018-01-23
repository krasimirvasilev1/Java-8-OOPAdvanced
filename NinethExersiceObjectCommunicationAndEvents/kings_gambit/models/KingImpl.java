package NinethExersiceObjectCommunicationAndEvents.kings_gambit.models;

import NinethExersiceObjectCommunicationAndEvents.kings_gambit.interfaces.King;

import java.util.LinkedList;
import java.util.List;

public class KingImpl extends Person implements King{

    private List<Person> peopleNextToTheKing;


    public KingImpl(String name) {
        super(name);
        this.peopleNextToTheKing = new LinkedList<>();
    }

    @Override
    public void addAGuardToTheKing(String personName) {
        RoyalGuard royalGuard = new RoyalGuard(personName);
        this.peopleNextToTheKing.add(royalGuard);
    }

    @Override
    public void addAFootmanToTheKing(String personName) {
        Footman footman = new Footman(personName);
        this.peopleNextToTheKing.add(footman);
    }

    @Override
    public void killGuardOrFootman(String name) {
        for (Person person : peopleNextToTheKing) {
            if (person.getName().equalsIgnoreCase(name)){
                this.peopleNextToTheKing.remove(person);
                break;
            }
        }
    }

    @Override
    public void kingIsUnderAttack(){
        System.out.println(this);
        for (Person person : peopleNextToTheKing) {
            System.out.println(person);
        }
    }


    @Override
    public String toString() {
        return String.format("King %s is under attack!",super.getName());
    }
}
