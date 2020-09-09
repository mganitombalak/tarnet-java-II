package com.tarnet.services.notification;

import com.tarnet.common.interfaces.INotificationService;

public class EmailService implements INotificationService {
    @Override
    public int getOrder() {
        return 3;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("Email notification: " + message);
    }
}
