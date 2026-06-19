package com.manoelcampos.desconto;

import com.manoelcampos.venda.Venda;

public class DescontoProgressivo implements IDesconto {

    /** Classe responsável pela lógica de calcular o desconto progressivo que
     * varia de acordo com o subtotal, com o percentual máximo de 20% de desconto.*/
    public DescontoProgressivo() {}

    @Override
    public double calcularDesconto(Venda venda) {
        var percentualDesconto = (Math.min(venda.getSubtotal()/25, 20)) / 100;

        return venda.getSubtotal() * percentualDesconto;
    }
}
