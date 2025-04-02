package com.logistica.frete;

public class FreteEconomico implements CalculadoraFrete {

    private static final double FATOR_ECO = 1.1;
    private static final double DESCONTO_ECO = -5;

    @Override
    public double calcularFrete(double peso) {
        return peso * FATOR_ECO + DESCONTO_ECO;
    }
}