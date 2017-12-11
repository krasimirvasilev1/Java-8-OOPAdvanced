package FirstExersiceInterfaceAndAbstraction.FoodShortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Buyer> buyers = new HashMap<>();
        List<Buyer> alreadyBought = new ArrayList<>();
        int numberForInput = Integer.parseInt(console.readLine());
        for (int i = 0; i < numberForInput; i++) {
            String[] input = console.readLine().split("\\s+");
            switch (input.length) {
                case 3:
                    Rebel rebel = new Rebel(input[0], Integer.parseInt(input[1]), input[2]);
                    if (!buyers.containsKey(rebel.getName())) {
                        buyers.put(rebel.getName(), rebel);
                    }
                    break;
                case 4:
                    Citizen citizen = new Citizen(input[0], Integer.parseInt(input[1]), input[2], input[3]);
                    if (!buyers.containsKey(citizen.getName())) {
                        buyers.put(citizen.getName(), citizen);
                    }
                    break;
            }
        }

        while (true) {
            String nameOfBuyer = console.readLine();
            if (nameOfBuyer.equalsIgnoreCase("End")) {
                break;
            }
            if (buyers.containsKey(nameOfBuyer)) {
                Buyer buyer = buyers.get(nameOfBuyer);
                if (buyer instanceof Rebel) {
                    buyer.buyFood(5);
                } else {
                    buyer.buyFood(10);
                }
            }
        }
        System.out.println(Citizen.foodBought + Rebel.foodBought);
    }
}
