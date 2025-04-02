package com.logistica.service;

import com.logistica.exception.EntregaInvalidaException;
import com.logistica.frete.CalculadoraFrete;
import com.logistica.frete.FreteEconomico;
import com.logistica.frete.FreteExpresso;
import com.logistica.frete.FretePadrao;
import com.logistica.model.Entrega;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;

public class EtiquetaServiceTest extends TestCase {

    @Test
    public void testGerarEtiquetaComFreteExpresso() {
        CalculadoraFrete calculadora = new FreteExpresso();
        EtiquetaService etiquetaService = new EtiquetaService(calculadora);

        Entrega entrega = new Entrega("Rua 123", 10, "EXP", "João");
        String etiqueta = etiquetaService.gerarEtiqueta(entrega);

        assertTrue(etiqueta.contains("Destinatário: João"));
        assertTrue(etiqueta.contains("Valor do Frete: R$25.0"));
    }

    @Test
    public void testGerarResumoPedidoComFretePadrao() {
        CalculadoraFrete calculadora = new FretePadrao();
        EtiquetaService etiquetaService = new EtiquetaService(calculadora);

        Entrega entrega = new Entrega("Rua 456", 10, "PAD", "Maria");
        String resumo = etiquetaService.gerarResumoPedido(entrega);

        assertTrue(resumo.contains("Pedido para Maria"));
        assertTrue(resumo.contains("frete tipo PAD"));
        assertTrue(resumo.contains("no valor de R$12.0"));
    }

    @Test
    public void testGerarEtiquetaComEntregaInvalida() {
        CalculadoraFrete calculadora = new FreteEconomico();
        EtiquetaService etiquetaService = new EtiquetaService(calculadora);


        EntregaInvalidaException exception = assertThrows(EntregaInvalidaException.class, () -> {
            Entrega entrega = new Entrega("Rua 789", -1, "ECO", "Pedro");
            etiquetaService.gerarEtiqueta(entrega);
        });

        assertEquals("Peso inválido", exception.getMessage());
    }



}