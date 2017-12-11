package FirstExersiceInterfaceAndAbstraction.Ferrari;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Ferrari ferrari = new Ferrari(console.readLine());
        System.out.println(ferrari.getModel()+"/"+ferrari.useBrakes()+"/"+ferrari.pushTheGasPedal()+"/"+ferrari.getDriver());
    }
}
