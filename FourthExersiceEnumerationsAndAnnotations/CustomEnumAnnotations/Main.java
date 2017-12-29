package FourthExersiceEnumerationsAndAnnotations.CustomEnumAnnotations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String input = console.readLine();

        if (input.equalsIgnoreCase(Rank.class.getAnnotation(ClassAnnotation.class).category())){
            System.out.println("Type = Enumeration, Description = "+Rank.class.getAnnotation(ClassAnnotation.class).description());
        }
        else if (input.equalsIgnoreCase(Suit.class.getAnnotation(ClassAnnotation.class).category())){
            System.out.println("Type = Enumeration, Description = "+Suit.class.getAnnotation(ClassAnnotation.class).description());
        }
    }
}
