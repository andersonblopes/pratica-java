package com.lopes.ioc.notificate;

import com.lopes.ioc.model.Client;

public class NotificationByEmail implements Notificator {

    @Override
    public void notify(Client client, String message) {
        System.out.printf("Notifying %s via e-mail %s: %s\n",
                client.getName(), client.getEmail(), message);

    }
}
