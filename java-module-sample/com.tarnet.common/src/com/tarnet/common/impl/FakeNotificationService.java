package com.tarnet.common.impl;

import com.tarnet.common.interfaces.INotificationService;

public class FakeNotificationService implements INotificationService {


    @Override
    public int getOrder() {
        return 4;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("Fake notification: " + message);
    }
}
