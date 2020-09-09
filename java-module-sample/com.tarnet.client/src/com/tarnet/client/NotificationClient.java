package com.tarnet.client;

import com.tarnet.common.interfaces.INotificationService;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

public class NotificationClient {
    public static void main(String[] args) {
        INotificationService service = null;
        List<INotificationService> services = ServiceLoader.load(INotificationService.class)
                .stream()
                .map(sl -> sl.get())
                .sorted(Comparator.comparingInt(INotificationService::getOrder))
                .collect(Collectors.toList());

        services.forEach(s -> s.sendNotification("Gani"));

        Class t = services.get(4).getClass();
        System.out.println(t.getName());
        new Scanner(System.in).next();
    }
}
