package com.tarnet.zava;

import com.tarnet.common.interfaces.INotificationService;

public class ZavaNotificationService implements INotificationService {
    @Override
    public int getOrder() {
        return 1;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("Zava notification: " + message);
    }
}
