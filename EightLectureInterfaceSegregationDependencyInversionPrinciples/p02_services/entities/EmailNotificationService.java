package EightLectureInterfaceSegregationDependencyInversionPrinciples.p02_services.entities;

import EightLectureInterfaceSegregationDependencyInversionPrinciples.p02_services.interfaces.NotificationService;

public class EmailNotificationService extends NotificationServiceImpl implements NotificationService {

    public EmailNotificationService(boolean isActive) {
        super(isActive);
    }

    public void sendNotification() {
        if (super.isActive()){
            System.out.println("You have an email");
        }
    }
}
