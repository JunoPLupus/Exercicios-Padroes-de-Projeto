package com.manoelcampos.newsletter;

import com.manoelcampos.message.MessageService;
import com.manoelcampos.people.Customer;

import java.util.List;

/**
 * Envia mensagens em massa para uma lista de clientes,
 * utilizando algum {@link MessageService}.
 *
 * @author Manoel Campos da Silva Filho
 * @author Juno Piazza Lopes
 */
public abstract class NewsletterAbstract implements Newsletter {
    private final List<Customer> customers;
    private final MessageService messageService;

    /**
     * Instancia uma newsletter para envio de mensagens para uma determinada lista de clientes
     * @param customers lista de clientes para enviar mensagens
     */
    public NewsletterAbstract(final List<Customer> customers){
        this.customers = customers;
        this.messageService = createMessageService();
    }

    @Override
    public final void send(final String msgTemplate) {
        for (final Customer customer : customers) {
            messageService.send(customer, formatMsg(customer, msgTemplate));
        }
    }

    /**
     * Substitui marcações (placeholders) na mensagem por valores
     * de atributos de um cliente.
     *
     * @param customer cliente de destino
     * @param msgTemplate Um template de mensagem com marcações (placeholders)
     *        que serão substituídos por atributos do cliente de destino.
     * @return a mensagem com as marcações substituídas pelos atributos do cliente.
     */
    private String formatMsg(final Customer customer, final String msgTemplate) {
        return msgTemplate
            .replaceAll("#name", customer.getName())
            .replaceAll("#email", customer.getEmail())
            .replaceAll("#phone", customer.getPhone());
    }

    /**
     * Retorna objeto usado para instanciar o atributo {@link #messageService}.
     *
     * @return classe concreta do tipo {@link MessageService}
     */
    protected abstract MessageService createMessageService();
}
