package ThirdExersiceIteratorsAndComparators.PetClinics;

public class Room {
    private Pet petInTheRoom = null;

    public Room(Pet petInTheRoom) {
        this.petInTheRoom = petInTheRoom;
    }

    @Override
    public String toString() {
        if (this.petInTheRoom == null){
            return "Room empty";
        }
        return this.petInTheRoom.toString();
    }
}
