package com.manoelcampos.newsletter;

import com.manoelcampos.message.Email;
import com.manoelcampos.message.MessageService;
import com.manoelcampos.people.Customer;

import java.util.List;

public class NewsletterEmail extends NewsletterAbstract {

    public NewsletterEmail(final List<Customer> customers) {
        super(customers);
    }

    @Override
    protected MessageService createMessageService() {
        return new Email();
    }
}
