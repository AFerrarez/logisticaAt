package com.logistica.exception;

public class FreteInvalidoException extends RuntimeException {
    public FreteInvalidoException(String mensagem) {
        super(mensagem);
    }
}