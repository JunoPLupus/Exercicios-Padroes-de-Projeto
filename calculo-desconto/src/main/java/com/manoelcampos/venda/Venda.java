package com.manoelcampos.venda;

import com.manoelcampos.cliente.Cliente;
import com.manoelcampos.desconto.DescontoDefinido;
import com.manoelcampos.desconto.IDesconto;

import java.time.LocalDate;

/**
 * Venda realizada para um {@link Cliente}.
 * @author Manoel Campos da Silva Filho
 */
public class Venda {
    private long id;
    private Cliente cliente;
    private LocalDate data;
    private double subtotal;
    private IDesconto tipoDesconto;

    public Venda() {/**/}

    public Venda(Cliente cliente, LocalDate data, double valorTotal) {
        this.cliente = cliente;
        this.data = data;
        this.subtotal = valorTotal;
        setTipoDesconto(new DescontoDefinido());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void setTipoDesconto(IDesconto tipoDesconto) {
        this.tipoDesconto = tipoDesconto;
    }

    /**
     * Calcula e exibe o subtotal, desconto e total.
     * <p>
     * O desconto padrão é de 0%, pode variar de acordo com o `tipoDesconto` definido.
     */
    public void calcularTotal() {
        var desconto = this.tipoDesconto.calcularDesconto(this);
        var valorFinal = this.subtotal - desconto;

        System.out.printf("Subtotal: R$%.2f\n", this.subtotal);
        System.out.printf("Desconto: R$%.2f\n", desconto);
        System.out.printf("Total: R$%.2f\n", valorFinal);
    }
}
