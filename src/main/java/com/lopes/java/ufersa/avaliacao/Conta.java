package com.lopes.java.ufersa.avaliacao;

public class Conta {

    private double saldo;

    public Conta(double saldo)
    {
        this.setSaldo(saldo);
    }

    public void depositar(double valor)
    {

    }

    public double getSaldo()
    {
        return saldo;
    }

    public void sacar(double valor)
    {
        tarifar(valor);
        saldo -= valor;

    }

    public void setSaldo(double saldo)
    {
        this.saldo = saldo;
    }

    public void tarifar(double valor)
    {
        setSaldo(getSaldo() - valor * 0.05);
    }

}
