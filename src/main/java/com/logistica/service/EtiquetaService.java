package com.logistica.service;

import com.logistica.exception.EntregaInvalidaException;
import com.logistica.model.Entrega;
import com.logistica.frete.CalculadoraFrete;

public class EtiquetaService {

    private final CalculadoraFrete calculadoraFrete;


    public EtiquetaService(CalculadoraFrete calculadoraFrete) {
        this.calculadoraFrete = calculadoraFrete;
    }


    public String gerarEtiqueta(Entrega entrega) {
        try {
            validarEntrega(entrega);
            double valorFrete = calculadoraFrete.calcularFrete(entrega.getPeso());
            return "Destinatário: " + entrega.getDestinatario() + "\n" +
                    "Endereço: " + entrega.getEndereco() + "\n" +
                    "Valor do Frete: R$" + valorFrete;
        } catch (EntregaInvalidaException e) {
            return "Erro ao gerar etiqueta: " + e.getMessage();
        }
    }


    public String gerarResumoPedido(Entrega entrega) {
        try {
            validarEntrega(entrega);
            double valorFrete = calculadoraFrete.calcularFrete(entrega.getPeso());
            return "Pedido para " + entrega.getDestinatario() + " com frete tipo " + entrega.getTipoFrete() + " no valor de R$" + valorFrete;
        } catch (EntregaInvalidaException e) {
            return "Erro ao gerar resumo do pedido: " + e.getMessage();
        }
    }

    // Valida os dados de entrega
    private void validarEntrega(Entrega entrega) {
        if (entrega.getEndereco() == null || entrega.getEndereco().isEmpty()) {
            throw new EntregaInvalidaException("Endereço inválido");
        }
        if (entrega.getPeso() <= 0) {
            throw new EntregaInvalidaException("Peso inválido");
        }
        if (entrega.getTipoFrete() == null || entrega.getTipoFrete().isEmpty()) {
            throw new EntregaInvalidaException("Tipo de frete inválido");
        }
        if (entrega.getDestinatario() == null || entrega.getDestinatario().isEmpty()) {
            throw new EntregaInvalidaException("Destinatário inválido");
        }
    }
}