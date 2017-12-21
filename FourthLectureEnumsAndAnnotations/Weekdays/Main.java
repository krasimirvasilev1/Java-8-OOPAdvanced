package FourthLectureEnumsAndAnnotations.Weekdays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        WeeklyCalendar wc = new WeeklyCalendar();
        wc.addEntry("Friday","sleep");
        wc.addEntry("Monday","sport");

        for (WeeklyEntry weeklyEntry : wc.getWeeklySchedule()) {
            System.out.println(weeklyEntry);
        }
    }
}
