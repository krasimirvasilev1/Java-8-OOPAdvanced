package FourthLectureEnumsAndAnnotations.CoffeeMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        while(true){
            String line = console.readLine();
            if (line.equalsIgnoreCase("end")){
                break;
            }
            String[] input = line.split("\\s+");
            if (input.length == 1){
                coffeeMachine.insertCoin(input[0]);
            }
            else {
                coffeeMachine.buyCoffee(input[0],input[1]);
            }
        }

        for (Coffee coffee : coffeeMachine.coffeesSold()) {
            System.out.println(coffee);
        }
    }
}
