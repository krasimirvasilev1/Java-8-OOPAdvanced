package EightLectureInterfaceSegregationDependencyInversionPrinciples.p02_services.engine;

import EightLectureInterfaceSegregationDependencyInversionPrinciples.p02_services.interfaces.NotificationService;

public class OnlineStoreOrder {

    private NotificationService emailNotification;
    private NotificationService smsNotification;

    public OnlineStoreOrder(NotificationService emailNotificationService, NotificationService smsNotificationService) {
        this.emailNotification = emailNotificationService;
        this.smsNotification = smsNotificationService;
    }

    public void process() {
        if (this.emailNotification.isActive()) {
            this.emailNotification.sendNotification();
        }
        if (this.smsNotification.isActive()) {
            this.smsNotification.sendNotification();
        }
    }
}
