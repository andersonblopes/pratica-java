package com.lopes.java.ufersa.aula02;

public class Professor extends Funcionario {

    public Professor(String nome, String sobrenome, int matricula)
    {
        super(nome, sobrenome, matricula);
    }

    @Override
    public double getSalarioPrimeiraParcela()
    {
        return getSalario();
    }

    @Override
    public double getSalarioSegundaParcela()
    {
        return 0.0;
    }
}
