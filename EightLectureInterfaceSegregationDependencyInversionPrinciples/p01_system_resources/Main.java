package EightLectureInterfaceSegregationDependencyInversionPrinciples.p01_system_resources;

import EightLectureInterfaceSegregationDependencyInversionPrinciples.p01_system_resources.entities.GreetingClock;
import EightLectureInterfaceSegregationDependencyInversionPrinciples.p01_system_resources.entities.TimeProviderImpl;
import EightLectureInterfaceSegregationDependencyInversionPrinciples.p01_system_resources.entities.WriterImpl;
import EightLectureInterfaceSegregationDependencyInversionPrinciples.p01_system_resources.interfaces.TimeProvider;

public class Main {
    public static void main(String[] args) {
        TimeProvider timeProvider = new TimeProviderImpl();
        WriterImpl writer = new WriterImpl();
        GreetingClock greetingClock = new GreetingClock(timeProvider,writer);

        greetingClock.greeting();
    }
}
