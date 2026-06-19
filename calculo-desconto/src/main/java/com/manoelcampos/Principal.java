package com.manoelcampos;

import com.manoelcampos.cliente.Cliente;
import com.manoelcampos.desconto.DescontoAniversario;
import com.manoelcampos.desconto.DescontoDefinido;
import com.manoelcampos.desconto.DescontoProgressivo;
import com.manoelcampos.venda.Venda;

import java.time.LocalDate;

public class Principal {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(1, "Juno", LocalDate.of(1998, 6, 19));

        Venda venda = new Venda(cliente, LocalDate.now(), 1179.92);

        System.out.println("\n======== Venda com desconto definido padrão de 0% ========");
        venda.calcularTotal();

        System.out.println("\n======== Venda com desconto definido de 10% ========");
        venda.setTipoDesconto(new DescontoDefinido(10));
        venda.calcularTotal();

        System.out.println("\n======== Venda com possível desconto de aniversário ========");
        venda.setTipoDesconto(new DescontoAniversario());
        venda.calcularTotal();

        System.out.println("\n======== Venda com desconto progressivo ========");
        venda.setTipoDesconto(new DescontoProgressivo());
        venda.calcularTotal();
    }
}
