package com.lopes.ioc.service;

import com.lopes.ioc.model.Client;
import com.lopes.ioc.notificate.Notificator;

public class ActivatorClientService {

    private Notificator notificator;

    public ActivatorClientService(Notificator notificator) {
        this.notificator = notificator;
    }

    public void active(Client client) {
        client.isActive();

        this.notificator.notify(client, "Your registration in the system is active!");
    }
}
