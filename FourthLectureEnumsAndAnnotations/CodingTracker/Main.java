package FourthLectureEnumsAndAnnotations.CodingTracker;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Tracker.printMethodsByAuthor(Tracker.class);
    }
}
