package EightLectureInterfaceSegregationDependencyInversionPrinciples.p01_system_resources.entities;

import EightLectureInterfaceSegregationDependencyInversionPrinciples.p01_system_resources.interfaces.TimeProvider;
import EightLectureInterfaceSegregationDependencyInversionPrinciples.p01_system_resources.interfaces.Writer;


public class GreetingClock {

    private TimeProvider time;
    private Writer writer;

    public GreetingClock(TimeProvider time, Writer writer) {
        this.time = time;
        this.writer = writer;
    }

    public void greeting() {
        if (this.time.getHour() < 12) {
            System.out.println("Good morning...");
        } else if (this.time.getHour() < 18) {
            System.out.println("Good afternoon...");
        } else {
            System.out.println("Good evening...");
        }
    }
}
