package com.lopes.ioc;

import com.lopes.ioc.model.Client;
import com.lopes.ioc.notificate.NotificationBySMS;
import com.lopes.ioc.notificate.Notificator;
import com.lopes.ioc.service.ActivatorClientService;

public class Ioc {

    public static void main(String[] args) {
        Client john = new Client("John", "joao@xyz.com", "3499998888");
        Client mary = new Client("Mary", "maria@xyz.com", "1177772222");

        Notificator notificator = new NotificationBySMS();

        ActivatorClientService activatorClientService = new ActivatorClientService(notificator);
        activatorClientService.active(john);
        activatorClientService.active(mary);
    }
}
