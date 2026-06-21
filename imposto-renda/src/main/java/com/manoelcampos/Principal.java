package com.manoelcampos;

import com.manoelcampos.impostorenda.*;

public class Principal {
    public static void main(String[] args) {
        PessoaFisica pf1 = new PessoaFisica(1, "Juno", 3_000.0);

        PessoaFisica pf2 = new PessoaFisica(2, "Manoel", 8_000.0);
        pf2.setDeducaoDependentes(500.0);
        pf2.setGastosSaude(300.0);
        pf2.setGastosEducacao(200.0);

        PessoaJuridica pj1 = new PessoaJuridica(3, "Empresa XYZ", 150_000.0, 20_000.0);

        imprimirImpostos(pf1);
        imprimirImpostos(pf2);
        imprimirImpostos(pj1);
    }

    private static void imprimirImpostos(Pessoa pessoa) {
        System.out.printf("%-15s => Total de impostos: R$ %.2f%n",
                pessoa.getNome(), pessoa.calcularTotalImpostos());
    }
}
