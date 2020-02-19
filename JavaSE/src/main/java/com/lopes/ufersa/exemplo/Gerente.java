package com.lopes.java.ufersa.exemplo;

public class Gerente extends Empregado {

    private String departamento;

    public Gerente(String nome, long cpf, double salario, String departamento)
    {
        super(nome, cpf, salario);
        this.departamento = departamento;
    }

    @Override
    public String tooString()
    {
        return super.tooString() + "\ndepartamento: " + departamento;
    }
}
