package EightLectureInterfaceSegregationDependencyInversionPrinciples.p02_services.entities;

import EightLectureInterfaceSegregationDependencyInversionPrinciples.p02_services.interfaces.NotificationService;

public abstract class NotificationServiceImpl implements NotificationService {
    private boolean isActive;

    public NotificationServiceImpl(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public boolean isActive() {
        return this.isActive;
    }
}
