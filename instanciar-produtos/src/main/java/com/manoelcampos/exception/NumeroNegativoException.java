package com.manoelcampos.exception;

public class NumeroNegativoException extends RuntimeException {
    public NumeroNegativoException(String campoNome) {
        super("O '"+ campoNome + "' não pode ser negativo.");
    }
}
