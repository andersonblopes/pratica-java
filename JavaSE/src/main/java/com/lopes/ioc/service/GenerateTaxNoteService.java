package com.lopes.ioc.service;

import com.lopes.ioc.model.Client;
import com.lopes.ioc.model.Product;
import com.lopes.ioc.notificate.Notificator;

public class GenerateTaxNoteService {

    private Notificator notificator;

    public GenerateTaxNoteService(Notificator notificator) {
        this.notificator = notificator;
    }

    public void generate(Client client, Product product) {
        // TODO Generates tax note here...

        this.notificator.notify(client, "Tax note of product "
                + product.getName() + " was generated!");
    }
}
