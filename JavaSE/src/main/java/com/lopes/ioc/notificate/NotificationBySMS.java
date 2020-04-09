package com.lopes.ioc.notificate;

import com.lopes.ioc.model.Client;

public class NotificationBySMS implements Notificator {

    @Override
    public void notify(Client client, String message) {
        System.out.printf("Notifying %s via phone %s: %s\n",
                client.getName(), client.getPhone(), message);

    }
}
