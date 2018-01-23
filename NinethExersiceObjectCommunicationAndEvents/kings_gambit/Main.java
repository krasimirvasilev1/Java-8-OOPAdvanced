package NinethExersiceObjectCommunicationAndEvents.kings_gambit;

import NinethExersiceObjectCommunicationAndEvents.kings_gambit.commands.CommandController;
import NinethExersiceObjectCommunicationAndEvents.kings_gambit.interfaces.King;
import NinethExersiceObjectCommunicationAndEvents.kings_gambit.models.KingImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        King king = new KingImpl(console.readLine());
        List<String> guards = Arrays.stream(console.readLine().split("\\s+")).collect(Collectors.toList());
        for (String guard : guards) {
            king.addAGuardToTheKing(guard);
        }

        List<String> footMans = Arrays.stream(console.readLine().split("\\s+")).collect(Collectors.toList());
        for (String footMan : footMans) {
            king.addAFootmanToTheKing(footMan);
        }

        while(true){
            String endCommand = CommandController.commandDispatcher(console.readLine().split("\\s+"),king);
            if ("End".equalsIgnoreCase(endCommand)){
                break;
            }
        }
    }
}
