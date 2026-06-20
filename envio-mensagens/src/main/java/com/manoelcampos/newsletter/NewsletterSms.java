package com.manoelcampos.newsletter;

import com.manoelcampos.message.MessageService;
import com.manoelcampos.message.Sms;
import com.manoelcampos.people.Customer;

import java.util.List;

public class NewsletterSms extends NewsletterAbstract {
    public NewsletterSms(List<Customer> customers) {
        super(customers);
    }

    @Override
    protected MessageService createMessageService() {
        return new Sms();
    }
}
