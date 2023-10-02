package com.lopes.ufersa.avaliacao;

public class ContaEspecial extends Conta {

    public ContaEspecial(double saldo)
    {
        super(saldo);
    }

    @Override
    public void tarifar(double valor)
    {
        setSaldo(getSaldo() - valor * 0.01);
    }

}
