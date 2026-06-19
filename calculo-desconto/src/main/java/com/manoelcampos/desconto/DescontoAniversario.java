package com.manoelcampos.desconto;

import com.manoelcampos.venda.Venda;

public class DescontoAniversario implements IDesconto {

    /** Classe responsável pela lógica de calcular o desconto de 15%
     * caso seja aniversário do cliente.*/
    public DescontoAniversario() {}

    @Override
    public double calcularDesconto(Venda venda) {
        if (venda.getCliente().isAniversario(venda.getData())) return venda.getSubtotal() * 0.15;

        return 0;
    }
}
