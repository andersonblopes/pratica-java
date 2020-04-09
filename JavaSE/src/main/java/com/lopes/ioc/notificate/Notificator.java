package com.lopes.ioc.notificate;

import com.lopes.ioc.model.Client;

public interface Notificator {

    void notify(Client client, String message);

}
