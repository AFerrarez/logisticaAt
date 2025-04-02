package com.logistica.model;

import com.logistica.exception.EntregaInvalidaException;

public final class Entrega {

    private final String endereco;
    private final double peso;
    private final String tipoFrete;
    private final String destinatario;

    // Construtor com validações explícitas
    public Entrega(String endereco, double peso, String tipoFrete, String destinatario) {
        if (endereco == null || endereco.isEmpty()) {
            throw new EntregaInvalidaException("Endereço inválido");
        }
        if (peso <= 0) {
            throw new EntregaInvalidaException("Peso inválido");
        }
        if (tipoFrete == null || tipoFrete.isEmpty()) {
            throw new EntregaInvalidaException("Tipo de frete inválido");
        }
        if (destinatario == null || destinatario.isEmpty()) {
            throw new EntregaInvalidaException("Destinatário inválido");
        }

        this.endereco = endereco;
        this.peso = peso;
        this.tipoFrete = tipoFrete;
        this.destinatario = destinatario;
    }


    public String getEndereco() {
        return endereco;
    }

    public double getPeso() {
        return peso;
    }

    public String getTipoFrete() {
        return tipoFrete;
    }

    public String getDestinatario() {
        return destinatario;
    }
}