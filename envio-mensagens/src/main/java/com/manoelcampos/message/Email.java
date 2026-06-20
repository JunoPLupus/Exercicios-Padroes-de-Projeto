package com.manoelcampos.message;

import com.manoelcampos.exception.MessageSendException;
import com.manoelcampos.people.Customer;

/**
 * Envia mensagens de email.
 * @author Manoel Campos da Silva Filho
 * @author Juno Piazza Lopes
 */
public class Email implements MessageService {
    /**
     * {@inheritDoc}
     * @param customer para extrair e-mail de destino da mensagem
     * @param msg {@inheritDoc}
     * @throws MessageSendException {@inheritDoc}
     */
    @Override
    public void send(final Customer customer, final String msg) throws MessageSendException {
        System.out.printf("Enviando E-mail para %s: %s%n", customer.getEmail(), msg);
    }
}
