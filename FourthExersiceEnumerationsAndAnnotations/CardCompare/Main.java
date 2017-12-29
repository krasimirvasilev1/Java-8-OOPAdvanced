package FourthExersiceEnumerationsAndAnnotations.CardCompare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        CardPower cardOne = new CardPower(console.readLine(),console.readLine());
        CardPower cardTwo = new CardPower(console.readLine(),console.readLine());

        int compareTwoCards = cardOne.compareTo(cardTwo);
        if (compareTwoCards > 0){
            System.out.println(cardOne);
        }
        else {
            System.out.println(cardTwo);
        }
    }
}
