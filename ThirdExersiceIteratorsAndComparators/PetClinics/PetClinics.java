package ThirdExersiceIteratorsAndComparators.PetClinics;

import java.util.*;

public class PetClinics{
    private Map<String,Pet> allPets;
    private Map<String,Clinic> clinics;

    public PetClinics() {
        this.allPets = new HashMap<>();
        this.clinics= new HashMap<>();
    }

    public void createPet(String name,int age,String kind){
        Pet pet = new Pet(name,age,kind);
        this.allPets.put(name,pet);
    }

    public void createClinic(String name,int rooms){
        Clinic clinic = new Clinic(name,rooms);
        this.clinics.put(name,clinic);
    }

    public boolean add (String namePet,String nameClinic){
        Pet pet = null;
        Clinic clinic = null;
        if (this.allPets.containsKey(namePet)){
            pet = this.allPets.get(namePet);
        }
        if (this.clinics.containsKey(nameClinic)){
            clinic = this.clinics.get(nameClinic);
        }

        if (pet != null && clinic != null){
            return fillTheClinic(this.allPets.get(namePet),this.clinics.get(nameClinic));
        }
        else {
            return false;
        }
    }

    public boolean release (String nameClinic){
        if (this.clinics.containsKey(nameClinic)){
            return releaseFromTheClinic(this.clinics.get(nameClinic));
        }
        else {
            return false;
        }
    }

    public boolean hasEmptyRooms (String nameClinic){
        if (this.clinics.containsKey(nameClinic)){
            return checkForEmptyRooms(this.clinics.get(nameClinic));
        }
        else {
            return false;
        }
    }

    public void print (String clinicName){
        Clinic clinic = this.clinics.get(clinicName);
        for (int i = 0; i < clinic.getRooms().length; i++) {
            System.out.println(clinic.getRooms()[i]);
        }
    }

    public void printClinicRoom(String clinicName,int number){
        Clinic clinic = this.clinics.get(clinicName);
        System.out.println(clinic.getRooms()[number - 1]);
    }

    private boolean fillTheClinic(Pet pet, Clinic clinic){
        int index = clinic.getRooms().length / 2;
        if (clinic.getRooms()[index] == null){
            clinic.getRooms()[index] = new Room(pet);
            return true;
        }
        else {
            int diff = 1;
            while (true){
                if (index - diff < 0 || index + diff > clinic.getRooms().length - 1){
                    return false;
                }
                if (clinic.getRooms()[index - diff] == null){
                    clinic.getRooms()[index - diff] = new Room(pet);
                    return true;
                }
                else if(clinic.getRooms()[index + diff] == null){
                    clinic.getRooms()[index + diff] = new Room(pet);
                    return true;
                }
                diff++;
            }
        }
    }

    private boolean releaseFromTheClinic (Clinic clinic){
        int index = clinic.getRooms().length / 2;
        if (clinic.getRooms()[index] != null){
            clinic.getRooms()[index] = null;
            return true;
        }
        else {
            while(true){
                for (int i = index; i < clinic.getRooms().length; i++) {
                    if (clinic.getRooms()[i] != null){
                        clinic.getRooms()[i] = null;
                        return true;
                    }
                }
                for (int i = clinic.getRooms().length - 1; i >= index ; i--) {
                    if (clinic.getRooms()[i] != null){
                        clinic.getRooms()[i] = null;
                        return true;
                    }
                }
                return false;
            }
        }
    }

    private boolean checkForEmptyRooms (Clinic clinic){
        for (int i = 0; i < clinic.getRooms().length; i++) {
            if (clinic.getRooms()[i] == null){
                return true;
            }
        }

        return false;
    }
}
