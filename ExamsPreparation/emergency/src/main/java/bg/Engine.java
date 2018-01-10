package bg;

import bg.softuni.core.EmergencyManagementSystemImpl;
import bg.softuni.interfaces.EmergencyManagementSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Engine {

    private BufferedReader bufferedReader;
    private EmergencyManagementSystem emergencyManagementSystem;

    public Engine() {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        this.emergencyManagementSystem = new EmergencyManagementSystemImpl();
    }

    public void run() throws IOException {
        while (true) {
            List<String> stringList = Arrays.asList(this.bufferedReader.readLine().split("\\|"));
            String result = "";
            switch (stringList.get(0)) {
                case "RegisterPropertyEmergency":
                    result = this.emergencyManagementSystem.registerPropertyEmergency(stringList);
                    break;
                case "RegisterHealthEmergency":
                    result = this.emergencyManagementSystem.registerHealthEmergency(stringList);
                    break;
                case "RegisterOrderEmergency":
                    result = this.emergencyManagementSystem.registerOrderEmergency(stringList);
                    break;
                case "RegisterFireServiceCenter":
                    result = this.emergencyManagementSystem.registerFireServiceCenter(stringList);
                    break;
                case "RegisterMedicalServiceCenter":
                   result = this.emergencyManagementSystem.registerMedicalServiceCenter(stringList);
                    break;
                case "RegisterPoliceServiceCenter":
                   result = this.emergencyManagementSystem.registerPoliceServiceCenter(stringList);
                    break;
                case "ProcessEmergencies":
                    result = this.emergencyManagementSystem.processEmergencies(stringList);
                case "EmergencyReport":
                    result = this.emergencyManagementSystem.emergencyReport();
                    break;
                default:
                    break;
            }

            if ("EmergencyBreak".equalsIgnoreCase(stringList.get(0))) {
                break;
            }

            System.out.println(result);
        }
    }
}
