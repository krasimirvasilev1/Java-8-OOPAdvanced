package FourthExersiceEnumerationsAndAnnotations.CardRank;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));


        System.out.println("Card Ranks:");
        for (Object o : CardRank.values()) {
            System.out.println(o);
        }
    }
}
