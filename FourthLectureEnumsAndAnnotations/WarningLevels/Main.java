package FourthLectureEnumsAndAnnotations.WarningLevels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        Importance importance = Importance.valueOf(console.readLine().toUpperCase());

        Logger logger = new Logger(importance);
        while(true){
            String input = console.readLine();
            if ("end".equalsIgnoreCase(input)){
                break;
            }

            String[] arrayCommand = input.split(":\\s+");
            logger.messageChecker(Importance.valueOf(arrayCommand[0]),arrayCommand[1]);
        }

        for (Message message : logger.iterator()) {
            System.out.println(message);
        }
    }
}
