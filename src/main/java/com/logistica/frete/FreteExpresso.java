package com.logistica.frete;

import com.logistica.exception.FreteInvalidoException;

public class FreteExpresso implements CalculadoraFrete {

    private static final double FATOR_EXP = 1.5;
    private static final double VALOR_ADICIONAL_EXP = 10;

    @Override
    public double calcularFrete(double peso) {
        if (peso <= 0) {
            throw new FreteInvalidoException("Peso inválido para frete expresso");
        }
        return peso * FATOR_EXP + VALOR_ADICIONAL_EXP;
    }
}