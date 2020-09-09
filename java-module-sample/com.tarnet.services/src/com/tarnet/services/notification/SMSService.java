package com.tarnet.services.notification;

import com.tarnet.common.interfaces.INotificationService;

public class SMSService implements INotificationService {
    @Override
    public int getOrder() {
        return 2;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("SMS notification: " + message);
    }
}
