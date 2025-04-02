package com.logistica.model;

import junit.framework.TestCase;

import com.logistica.model.Entrega;
import com.logistica.exception.EntregaInvalidaException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EntregaTest {

    @Test
    void testEntregaComEnderecoNulo() {
        Exception exception = assertThrows(EntregaInvalidaException.class, () -> {
            new Entrega(null, 10, "EXP", "João");
        });
        assertEquals("Endereço inválido", exception.getMessage());
    }

    @Test
    void testEntregaComPesoZero() {
        Exception exception = assertThrows(EntregaInvalidaException.class, () -> {
            new Entrega("Rua 123", 0, "EXP", "João");
        });
        assertEquals("Peso inválido", exception.getMessage());
    }

    @Test
    void testEntregaComTipoFreteNulo() {
        Exception exception = assertThrows(EntregaInvalidaException.class, () -> {
            new Entrega("Rua 123", 10, null, "João");
        });
        assertEquals("Tipo de frete inválido", exception.getMessage());
    }
}