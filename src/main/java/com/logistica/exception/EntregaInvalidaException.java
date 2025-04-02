package com.logistica.exception;

public class EntregaInvalidaException extends RuntimeException {
    public EntregaInvalidaException(String mensagem) {
        super(mensagem);
    }
}