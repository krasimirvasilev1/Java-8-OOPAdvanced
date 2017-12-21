package FourthLectureEnumsAndAnnotations.Weekdays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WeeklyCalendar {

    private List<WeeklyEntry> weekdays;

    public WeeklyCalendar() {
        this.weekdays = new ArrayList<>();
    }

    public void addEntry(String weekday, String notes){
        weekdays.add(new WeeklyEntry(weekday,notes));
    }


    public Iterable<WeeklyEntry> getWeeklySchedule() {
        this.weekdays.sort(Comparator.naturalOrder());
        return this.weekdays;
    }
}
