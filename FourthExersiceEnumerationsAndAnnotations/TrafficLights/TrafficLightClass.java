package FourthExersiceEnumerationsAndAnnotations.TrafficLights;

import java.util.ArrayList;
import java.util.List;

public class TrafficLightClass {
    private static List<TrafficLight> trafficLightList;

    public TrafficLightClass() {
        trafficLightList = new ArrayList<>();
    }

    public static List<TrafficLight> getTrafficLightList() {
        return trafficLightList;
    }

    public void addTrafficLight(TrafficLight trafficLight) {
        trafficLightList.add(trafficLight);
    }

    public static void rotate() {

        List<TrafficLight> trafficLights = new ArrayList<>();
        for (TrafficLight trafficLight : trafficLightList) {
            if (trafficLight.ordinal() == 0) {
                trafficLights.add(TrafficLight.GREEN);

            } else if (trafficLight.ordinal() == 1) {
                trafficLights.add(TrafficLight.YELLOW);

            } else {
                trafficLights.add(TrafficLight.RED);
            }
        }

        trafficLightList = trafficLights;
    }
}
