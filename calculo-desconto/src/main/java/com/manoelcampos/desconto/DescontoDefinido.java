package com.manoelcampos.desconto;

import com.manoelcampos.venda.Venda;

public class DescontoDefinido implements IDesconto {
    /** Percentual de desconto */
    private int percentual;

    /** Classe responsável pela lógica de calcular o desconto através do percentual definido.
     * Percentual de desconto é 0% por padrão, podendo ser definido via construtor. */
    public DescontoDefinido() {}

    /** Classe responsável pela lógica de calcular o desconto através do percentual definido.
     * @param percentual (%) de desconto */
    public DescontoDefinido(int percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcularDesconto(Venda venda) {
        return venda.getSubtotal() * ((double) percentual / 100);
    }
}
