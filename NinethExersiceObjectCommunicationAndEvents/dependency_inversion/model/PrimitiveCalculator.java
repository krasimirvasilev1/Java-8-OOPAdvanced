package NinethExersiceObjectCommunicationAndEvents.dependency_inversion.model;


import NinethExersiceObjectCommunicationAndEvents.dependency_inversion.interfaces.CalculateOperations;
import NinethExersiceObjectCommunicationAndEvents.dependency_inversion.strategies.AdditionStrategy;
import NinethExersiceObjectCommunicationAndEvents.dependency_inversion.strategies.DivisionStrategy;
import NinethExersiceObjectCommunicationAndEvents.dependency_inversion.strategies.MultiplyStrategy;
import NinethExersiceObjectCommunicationAndEvents.dependency_inversion.strategies.SubtractionStrategy;

public class PrimitiveCalculator {

    private CalculateOperations calculateOperations;

    public PrimitiveCalculator(CalculateOperations calculateOperations){
        this.calculateOperations = calculateOperations;
    }

    public void changeStrategy(char operator){
        switch (operator){
            case '+':
                this.calculateOperations = new AdditionStrategy();
                break;
            case '-':
                this.calculateOperations = new SubtractionStrategy();
                break;
            case '/':
                this.calculateOperations = new DivisionStrategy();
                break;
            case '*':
                this.calculateOperations = new MultiplyStrategy();
                break;
        }
    }

    public int performCalculation(int firstOperand,int secondOperand){
       return this.calculateOperations.calculate(firstOperand,secondOperand);
    }
}
