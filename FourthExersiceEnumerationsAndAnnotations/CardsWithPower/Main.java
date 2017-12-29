package FourthExersiceEnumerationsAndAnnotations.CardsWithPower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        CardPower.cardPower(console.readLine(), console.readLine());


    }
}
