package EightLectureInterfaceSegregationDependencyInversionPrinciples.p02_services;

import EightLectureInterfaceSegregationDependencyInversionPrinciples.p02_services.engine.OnlineStoreOrder;
import EightLectureInterfaceSegregationDependencyInversionPrinciples.p02_services.entities.EmailNotificationService;
import EightLectureInterfaceSegregationDependencyInversionPrinciples.p02_services.entities.SmsNotificationService;
import EightLectureInterfaceSegregationDependencyInversionPrinciples.p02_services.interfaces.NotificationService;

public class Main {
    public static void main(String[] args) {
        NotificationService notificationService = new EmailNotificationService(true);
        NotificationService notificationService1 = new SmsNotificationService(true);
        OnlineStoreOrder onlineStoreOrder = new OnlineStoreOrder(notificationService,notificationService1);

        onlineStoreOrder.process();
    }
}
