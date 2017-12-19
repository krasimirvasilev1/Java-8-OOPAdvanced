package ThirdExersiceIteratorsAndComparators.PetClinics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Clinic {
    private String name;
    private Room[] rooms;

    public Clinic(String name ,int numberOfRooms) {
        setName(name);
        setRooms(numberOfRooms);
    }

    public void setRooms(int numberOfRooms) {
        if (numberOfRooms % 2 == 1){
            this.rooms = new Room[numberOfRooms];
        }
        else {
            throw new IllegalArgumentException("Invalid Operation!");
        }
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setName(String name) {
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
        Matcher matcher = pattern.matcher(name);

        if (matcher.find()){
            this.name = name;
        }
        else {
            throw new IllegalArgumentException("Invalid Operation!");
        }
    }
}
