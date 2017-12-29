package FourthExersiceEnumerationsAndAnnotations.TrafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        TrafficLightClass trafficLightClass = new TrafficLightClass();
        String[] lightColour = console.readLine().split("\\s+");
        for (String s : lightColour) {
            trafficLightClass.addTrafficLight(Enum.valueOf(TrafficLight.class,s));
        }

        int numberOfRotations = Integer.parseInt(console.readLine());

        for (int i = 0; i < numberOfRotations; i++) {
            StringBuilder builder = new StringBuilder();
            TrafficLightClass.rotate();
            for (TrafficLight s : TrafficLightClass.getTrafficLightList()) {
                builder.append(s.name()+" ");
            }

            System.out.println(builder.toString().trim());
        }
    }
}
