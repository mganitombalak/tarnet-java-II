package com.tarnet.services.notification;

import com.tarnet.common.interfaces.INotificationService;

public class APNService implements INotificationService {
    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("Mobile notification: " + message);
    }
}
