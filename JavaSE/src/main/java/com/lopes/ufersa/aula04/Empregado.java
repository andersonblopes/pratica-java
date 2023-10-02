package com.lopes.ufersa.aula04;

public class Empregado {

    private String nome, endereco;
    private double salario;
    private int telefone;

    public Empregado(String nome, String endereco, int telefone, double salario)
    {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.setSalario(salario);
    }

    public String getEndereco()
    {
        return endereco;
    }

    public String getNome()
    {
        return nome;
    }

    public double getSalario()
    {
        return salario;
    }

    public int getTelefone()
    {
        return telefone;
    }

    public void setSalario(double salario)
    {
        this.salario = salario;
    }

    public String tooString()
    {
        return "\nNome: " + getNome() + "\nEndereço: " + getEndereco() + "\nTelefone: " + getTelefone() + "\nSalário:  "
                + getSalario();
    }
}
