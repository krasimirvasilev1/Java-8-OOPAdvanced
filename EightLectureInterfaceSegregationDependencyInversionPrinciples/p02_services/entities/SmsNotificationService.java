package EightLectureInterfaceSegregationDependencyInversionPrinciples.p02_services.entities;

import EightLectureInterfaceSegregationDependencyInversionPrinciples.p02_services.interfaces.NotificationService;

public class SmsNotificationService extends NotificationServiceImpl implements NotificationService {


    public SmsNotificationService(boolean isActive) {
        super(isActive);
    }

    @Override
    public void sendNotification() {
        if (super.isActive()) {
            System.out.println("You have an sms");
        }
    }
}
