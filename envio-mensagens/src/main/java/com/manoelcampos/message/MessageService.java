package com.manoelcampos.message;

import com.manoelcampos.exception.MessageSendException;
import com.manoelcampos.people.Customer;

/**
 * Interface para a implementação
 * de serviços de envio de mensagens, como {@link Sms},
 * {@link Email} e {@link WhatsApp}.
 * @author Manoel Campos da Silva Filho
 * @author Juno Piazza Lopes
 */
public interface MessageService {
    /**
     * Envia uma mensagem para um determinado cliente.
     * @param customer destino da mensagem, que pode ser um email ou número de telefone,
     *                    dependendo da implementação do serviço.
     * @param msg texto da mensagem
     * @throws MessageSendException
     */
    void send(Customer customer, String msg) throws MessageSendException;
}
