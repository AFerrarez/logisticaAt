package com.logistica.frete;

public class FretePadrao implements CalculadoraFrete {

    private static final double FATOR_PAD = 1.2;

    @Override
    public double calcularFrete(double peso) {
        return peso * FATOR_PAD;
    }
}