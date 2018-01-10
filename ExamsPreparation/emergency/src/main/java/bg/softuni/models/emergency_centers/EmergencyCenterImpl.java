package bg.softuni.models.emergency_centers;

import bg.softuni.interfaces.Emergency;
import bg.softuni.interfaces.EmergencyCenter;

import java.util.LinkedList;
import java.util.List;


public abstract class EmergencyCenterImpl implements EmergencyCenter {
    private String name;

    private Integer amountOfMaximumEmergencies;

    private Integer numberOfEmergenciesCalled;

    private List<Emergency> emergenciesPerCenter;

    private Boolean isForRetirement;

    protected EmergencyCenterImpl(String name, Integer amountOfMaximumEmergencies) {
        this.name = name;
        this.amountOfMaximumEmergencies = amountOfMaximumEmergencies;
        this.emergenciesPerCenter = new LinkedList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getAmountOfMaximumEmergencies() {
        return amountOfMaximumEmergencies;
    }

    @Override
    public Boolean isForRetirement() {
        if (this.emergenciesPerCenter.size() == this.amountOfMaximumEmergencies){
            return true;
        }
        return false;
    }

    @Override
    public void addEmergency(Emergency emergency){
        this.emergenciesPerCenter.add(emergency);
    }

}
