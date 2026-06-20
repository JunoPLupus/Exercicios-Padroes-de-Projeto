package com.manoelcampos.produtos;

import java.time.LocalDate;

public class Principal {
    public static void main(String[] args) {
        Produto produto = new Produto.
                ProdutoBuilder(1, "Teclado mecânico", "KODI", 120, "Periféricos")
                .dataUltimaAtualizacao(LocalDate.of(2026, 6, 30))
                .estoque(32)
                .build();

        System.out.println(produto);
    }
}
