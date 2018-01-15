package EightLectureInterfaceSegregationDependencyInversionPrinciples.p01_system_resources.entities;

import EightLectureInterfaceSegregationDependencyInversionPrinciples.p01_system_resources.interfaces.TimeProvider;

import java.time.LocalTime;


public class TimeProviderImpl implements TimeProvider {

    @Override
    public int getHour() {
        return LocalTime.now().getHour();
    }
}
