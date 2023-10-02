package com.lopes.ufersa.aula02;

public class Funcionario extends Pessoa {

    private int matricula;
    private double salario;

    public Funcionario(String nome, String sobrenome, int matricula)
    {
        super(nome, sobrenome);
        this.matricula = matricula;
    }

    public int getMatricula()
    {
        return matricula;
    }

    public double getSalario()
    {
        return salario;
    }

    public double getSalarioPrimeiraParcela()
    {
        return (getSalario() * 0.6);

    }

    public double getSalarioSegundaParcela()
    {
        return (getSalario() * 0.4);
    }

    public void setMatricula(int matricula)
    {
        this.matricula = matricula;
    }

    public void setSalario(double salario)
    {
        if (salario > 0)
        {
            this.setSalario(salario);
        }
    }

}
