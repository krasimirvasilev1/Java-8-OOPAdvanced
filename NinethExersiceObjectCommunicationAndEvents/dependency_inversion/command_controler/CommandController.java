package NinethExersiceObjectCommunicationAndEvents.dependency_inversion.command_controler;

import NinethExersiceObjectCommunicationAndEvents.dependency_inversion.model.PrimitiveCalculator;

public class CommandController {

    public static String dispatchCommand(String[] input, PrimitiveCalculator primitiveCalculator){
        switch (input[0]){
            case "mode":
                primitiveCalculator.changeStrategy(input[1].charAt(0));
                return null;
            case "End":
                return "End";
                default:
                    System.out.println(primitiveCalculator.performCalculation(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
                    return null;
        }
    }
}
