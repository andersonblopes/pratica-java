package com.lopes.ufersa.exemplo;

public class Empregado {

    private long cpf; // Acessível ao pacote
    private String nome; // Acesível á classe
    private double salaraio; // Acessível as subclasses

    public Empregado()
    {

    }

    public Empregado(String nome, long cpf, double salario)
    {
        this.nome = nome;
        this.cpf = cpf;
        this.salaraio = salario;
    }

    public String tooString()
    {
        return "Nome: " + nome + "\ncpf: " + cpf + "\nSal�rio: " + salaraio;
    }

}
