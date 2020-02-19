package com.lopes.java.ufersa.aula04;

public class Chefe extends Empregado {

    public Chefe(String nome, String endereco, int telefone, double salario)
    {
        super(nome, endereco, telefone, (salario * 1.1));
    }

}
