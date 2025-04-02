package com.logistica.model;

import com.logistica.frete.CalculadoraFrete;
import com.logistica.frete.FreteEconomico;
import com.logistica.frete.FreteExpresso;
import com.logistica.frete.FretePadrao;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FreteTest {

    @Test
    void testCalculoFreteExpresso() {
        CalculadoraFrete calculadora = new FreteExpresso();
        double frete = calculadora.calcularFrete(10);
        assertEquals(25.0, frete);
    }

    @Test
    void testCalculoFretePadrao() {
        CalculadoraFrete calculadora = new FretePadrao();
        double frete = calculadora.calcularFrete(10);
        assertEquals(12.0, frete);
    }

    @Test
    void testCalculoFreteEconomico() {
        CalculadoraFrete calculadora = new FreteEconomico();
        double frete = calculadora.calcularFrete(10);
        assertEquals(6.0, frete);
    }
}