package bg.softuni.interfaces;

import java.util.List;

public interface EmergencyManagementSystem {
    String registerPropertyEmergency(List<String> stringList);

    String registerHealthEmergency(List<String> stringList);

    String registerOrderEmergency(List<String> stringList);

    String registerFireServiceCenter(List<String> stringList);

    String registerMedicalServiceCenter(List<String> stringList);

    String registerPoliceServiceCenter(List<String> stringList);

    String processEmergencies(List<String> stringList);

    String emergencyReport();
}
