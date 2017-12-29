package FourthExersiceEnumerationsAndAnnotations.CardSuit;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));


        System.out.println("Card Suits:");
        for (Object o : CardSuit.values()) {
            System.out.println(o);
        }
    }
}
