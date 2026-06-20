package com.manoelcampos.message;

import com.manoelcampos.exception.MessageSendException;
import com.manoelcampos.people.Customer;

/**
 * Envia mensagens pelo Short Message Service (SMS)
 * @author Manoel Campos da Silva Filho
 * @author Juno Piazza Lopes
 */
public class Sms implements MessageService {
    /**
     * {@inheritDoc}
     * @param customer para extrair telefone de destino da mensagem
     * @param msg {@inheritDoc}
     * @throws MessageSendException {@inheritDoc}
     */
    @Override
    public void send(final Customer customer, final String msg) throws MessageSendException {
        System.out.printf("Enviando SMS para %s: %s%n", customer.getPhone(), msg);
    }
}
