package com.manoelcampos.desconto;

import com.manoelcampos.venda.Venda;

public interface IDesconto {
    /**
     * Calcula o valor do desconto, varia de acordo com o tipo do desconto.
     * @param venda para extrair as informações necessárias.
     * @return valor do desconto aplicado.
     */
    double calcularDesconto(Venda venda);
}
