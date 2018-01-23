package NinethExersiceObjectCommunicationAndEvents.dependency_inversion;

import NinethExersiceObjectCommunicationAndEvents.dependency_inversion.command_controler.CommandController;
import NinethExersiceObjectCommunicationAndEvents.dependency_inversion.model.PrimitiveCalculator;
import NinethExersiceObjectCommunicationAndEvents.dependency_inversion.strategies.AdditionStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        PrimitiveCalculator primitiveCalculator = new PrimitiveCalculator(new AdditionStrategy());

        while(true){
            String[] input = console.readLine().split("\\s+");
            String output = CommandController.dispatchCommand(input , primitiveCalculator);

            if ("End".equalsIgnoreCase(output)){
                break;
            }
        }
    }
}
