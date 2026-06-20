package com.manoelcampos.exception;

public class CampoObrigatorioException extends RuntimeException {
    public CampoObrigatorioException(String campoNome) {
        super("O campo '"+ campoNome + "' é obrigatório.");
    }
}
