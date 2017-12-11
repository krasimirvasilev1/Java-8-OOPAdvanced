package FirstExersiceInterfaceAndAbstraction.Telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Smartphone smartphone = new Smartphone();
        String[] number = console.readLine().split("\\s+");
        String[] url = console.readLine().split("\\s+");

        for (String s : number) {
            System.out.println(smartphone.call(s));
        }

        for (String s : url) {
            System.out.println(smartphone.browse(s));
        }
    }
}
