package com.manoelcampos.newsletter;

import com.manoelcampos.message.MessageService;
import com.manoelcampos.message.WhatsApp;
import com.manoelcampos.people.Customer;

import java.util.List;

public class NewsletterWhatsapp extends NewsletterAbstract {
    public NewsletterWhatsapp(List<Customer> customers) {
        super(customers);
    }

    @Override
    protected MessageService createMessageService() {
        return new WhatsApp();
    }
}
