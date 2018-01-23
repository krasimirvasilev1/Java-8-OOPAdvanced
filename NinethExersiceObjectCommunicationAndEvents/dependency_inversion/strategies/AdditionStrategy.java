package NinethExersiceObjectCommunicationAndEvents.dependency_inversion.strategies;

import NinethExersiceObjectCommunicationAndEvents.dependency_inversion.interfaces.CalculateOperations;

public class AdditionStrategy implements CalculateOperations {

    public int calculate(int firstOperand, int secondOperand){
        return firstOperand + secondOperand;
    }
}
