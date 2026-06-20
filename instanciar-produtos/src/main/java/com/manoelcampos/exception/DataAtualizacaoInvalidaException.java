package com.manoelcampos.exception;

public class DataAtualizacaoInvalidaException extends RuntimeException {
    public DataAtualizacaoInvalidaException() {
        super("A data de atualização não pode ser anterior à data de cadastro.");
    }
}
