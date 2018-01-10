package bg.softuni.core;

import bg.softuni.collection.EmergencyRegister;
import bg.softuni.enums.EmergencyLevel;
import bg.softuni.interfaces.Emergency;
import bg.softuni.interfaces.EmergencyCenter;
import bg.softuni.interfaces.EmergencyManagementSystem;
import bg.softuni.interfaces.Register;
import bg.softuni.models.emergency.PublicHealthEmergency;
import bg.softuni.models.emergency.PublicOrderEmergency;
import bg.softuni.models.emergency.PublicPropertyEmergency;
import bg.softuni.models.emergency_centers.FiremanServiceCenter;
import bg.softuni.models.emergency_centers.MedicalServiceCenter;
import bg.softuni.models.emergency_centers.PoliceServiceCenter;
import bg.softuni.utils.RegistrationTimeImpl;

import java.util.LinkedList;
import java.util.List;

public class EmergencyManagementSystemImpl implements EmergencyManagementSystem {
    private Register propertyEmergencies;
    private Register healthEmergencies;
    private Register orderEmergencies;
    private List<EmergencyCenter> propertyCenters;
    private List<EmergencyCenter> healthCenters;
    private List<EmergencyCenter> orderCenters;
    private int totalProcessedEmergencies;
    private int currentlyRegisteredEmergencies;
    private int totalPropertyDamageFixed;
    private int totalHealthCasualtiesSaved;
    private int totalSpecialCases;


    public EmergencyManagementSystemImpl() {
        this.propertyEmergencies = new EmergencyRegister();
        this.healthEmergencies = new EmergencyRegister();
        this.orderEmergencies = new EmergencyRegister();
        this.propertyCenters = new LinkedList<>();
        this.healthCenters = new LinkedList<>();
        this.orderCenters = new LinkedList<>();
        this.totalProcessedEmergencies = 0;
        this.currentlyRegisteredEmergencies = 0;
        this.totalPropertyDamageFixed = 0;
        this.totalHealthCasualtiesSaved = 0;
        this.totalSpecialCases = 0;
    }

    @Override
    public String registerPropertyEmergency(List<String> stringList) {
        Emergency emergency = new PublicPropertyEmergency(stringList.get(1), EmergencyLevel.valueOf(stringList.get(2)), new RegistrationTimeImpl(stringList.get(3)), Integer.parseInt(stringList.get(4)));
        this.propertyEmergencies.enqueueEmergency(emergency);
        this.currentlyRegisteredEmergencies++;

        return  String.format("Registered Public Property Emergency of level %s at %s.", emergency.getEmergencyLevel(), emergency.getRegistrationTimeImpl());
    }

    @Override
    public String registerHealthEmergency(List<String> stringList) {
        Emergency emergency = new PublicHealthEmergency(stringList.get(1), EmergencyLevel.valueOf(stringList.get(2)), new RegistrationTimeImpl(stringList.get(3)), Integer.parseInt(stringList.get(4)));
        this.healthEmergencies.enqueueEmergency(emergency);
        this.currentlyRegisteredEmergencies++;

        return String.format("Registered Public Health Emergency of level %s at %s.", emergency.getEmergencyLevel(), emergency.getRegistrationTimeImpl());
    }

    @Override
    public String registerOrderEmergency(List<String> stringList) {
        Emergency emergency = new PublicOrderEmergency(stringList.get(1), EmergencyLevel.valueOf(stringList.get(2)), new RegistrationTimeImpl(stringList.get(3)), stringList.get(4));
        this.orderEmergencies.enqueueEmergency(emergency);
        this.currentlyRegisteredEmergencies++;

        return String.format("Registered Public Order Emergency of level %s at %s.", emergency.getEmergencyLevel(), emergency.getRegistrationTimeImpl());
    }

    @Override
    public String registerFireServiceCenter(List<String> stringList) {
        EmergencyCenter emergencyCenter = new FiremanServiceCenter(stringList.get(1), Integer.parseInt(stringList.get(2)));
        this.propertyCenters.add(emergencyCenter);

        return String.format("Registered Fire Service Emergency Center - %s.", emergencyCenter.getName());
    }

    @Override
    public String registerMedicalServiceCenter(List<String> stringList) {
        EmergencyCenter emergencyCenter = new MedicalServiceCenter(stringList.get(1), Integer.parseInt(stringList.get(2)));
        this.healthCenters.add(emergencyCenter);

       return String.format("Registered Medical Service Emergency Center - %s.", emergencyCenter.getName());
    }

    @Override
    public String registerPoliceServiceCenter(List<String> stringList) {
        EmergencyCenter emergencyCenter = new PoliceServiceCenter(stringList.get(1), Integer.parseInt(stringList.get(2)));
        this.orderCenters.add(emergencyCenter);

        return String.format("Registered Police Service Emergency Center - %s.", emergencyCenter.getName());
    }

    @Override
    public String processEmergencies(List<String> stringList) {

        String result = "";
        switch (stringList.get(1)) {
            case "Property":
                for (EmergencyCenter propertyCenter : this.propertyCenters) {
                    while (!propertyCenter.isForRetirement()) {
                        if (this.propertyEmergencies.isEmpty()) {
                            break;
                        }
                        PublicPropertyEmergency emergency1 = (PublicPropertyEmergency) this.propertyEmergencies.dequeueEmergency();
                        propertyCenter.addEmergency(emergency1);
                        this.totalProcessedEmergencies++;
                        this.totalPropertyDamageFixed += emergency1.getDamage();
                        this.currentlyRegisteredEmergencies--;
                    }
                    if (this.propertyEmergencies.isEmpty()) {
                        break;
                    }
                }
                if (this.propertyEmergencies.isEmpty()) {
                    result = "Successfully responded to all Property emergencies.";
                } else {
                    Register cloneRegister = (Register) this.propertyEmergencies.clone();
                    int numberOfEmergencies = 0;
                    while (!cloneRegister.isEmpty()) {
                        cloneRegister.dequeueEmergency();
                        numberOfEmergencies++;
                    }
                    result = String.format("Property Emergencies left to process: %d.", numberOfEmergencies);
                }
                break;
            case "Health":
                for (EmergencyCenter healthCenter : this.healthCenters) {
                    while (!healthCenter.isForRetirement()) {
                        if (this.healthEmergencies.isEmpty()) {
                            break;
                        }
                        PublicHealthEmergency emergency1 = (PublicHealthEmergency) this.healthEmergencies.dequeueEmergency();
                        healthCenter.addEmergency(emergency1);
                        this.totalProcessedEmergencies++;
                        this.totalHealthCasualtiesSaved += emergency1.getNumberOfCasulties();
                        this.currentlyRegisteredEmergencies--;
                    }
                    if (this.healthEmergencies.isEmpty()) {
                        break;
                    }
                }
                if (this.healthEmergencies.isEmpty()) {
                    result = "Successfully responded to all Health emergencies.";
                } else {
                    Register cloneRegister = (Register) this.healthEmergencies.clone();
                    int numberOfEmergencies = 0;
                    while (!cloneRegister.isEmpty()) {
                        cloneRegister.dequeueEmergency();
                        numberOfEmergencies++;
                    }
                    result =  String.format("Health Emergencies left to process: %d.", numberOfEmergencies);
                }
                break;
            case "Order":
                for (EmergencyCenter orderCenter : this.orderCenters) {
                    while (!orderCenter.isForRetirement()) {
                        if (this.orderEmergencies.isEmpty()) {
                            break;
                        }
                        PublicOrderEmergency emergency1 = (PublicOrderEmergency) this.orderEmergencies.dequeueEmergency();
                        orderCenter.addEmergency(emergency1);
                        this.totalProcessedEmergencies++;
                        if (emergency1.isSpecialCase()) {
                            this.totalSpecialCases++;
                        }
                        this.currentlyRegisteredEmergencies--;
                    }
                    if (this.orderEmergencies.isEmpty()) {
                        break;
                    }
                }
                if (this.orderEmergencies.isEmpty()) {
                    result =  "Successfully responded to all Order emergencies.";
                } else {
                    Register cloneRegister = (Register) this.orderEmergencies.clone();
                    int numberOfEmergencies = 0;
                    while (!cloneRegister.isEmpty()) {
                        cloneRegister.dequeueEmergency();
                        numberOfEmergencies++;
                    }
                    result =  String.format("Order Emergencies left to process: %d.", numberOfEmergencies);
                }
                break;
        }

        return result;
    }

    @Override
    public String emergencyReport() {
        int currPropertyCenters = 0;
        int currHealthCenters = 0;
        int currOrderCenters = 0;
        for (EmergencyCenter propertyCenter : this.propertyCenters) {
            if (!propertyCenter.isForRetirement()){
                currPropertyCenters++;
            }
        }
        for (EmergencyCenter healthCenters : this.healthCenters) {
            if (!healthCenters.isForRetirement()){
                currHealthCenters++;
            }
        }
        for (EmergencyCenter orderCenters : this.orderCenters) {
            if (!orderCenters.isForRetirement()){
                currOrderCenters++;
            }
        }
        return String.format(
                "PRRM Services Live Statistics%n" +
                        "Fire Service Centers: %d%n" +
                        "Medical Service Centers: %d%n" +
                        "Police Service Centers: %d%n" +
                        "Total Processed Emergencies: %d%n" +
                        "Currently Registered Emergencies: %d%n" +
                        "Total Property Damage Fixed: %d%n" +
                        "Total Health Casualties Saved: %d%n" +
                        "Total Special Cases Processed: %d",currPropertyCenters,currHealthCenters
                ,currOrderCenters,this.totalProcessedEmergencies,this.currentlyRegisteredEmergencies,this.totalPropertyDamageFixed,
                this.totalHealthCasualtiesSaved,totalSpecialCases);
    }
}
