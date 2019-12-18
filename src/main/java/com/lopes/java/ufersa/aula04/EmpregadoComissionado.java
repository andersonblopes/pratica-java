package com.lopes.java.ufersa.aula04;

public class EmpregadoComissionado extends Empregado {

    public EmpregadoComissionado(String nome, String endereco, int telefone, double salario, double comissao,
            int qtdeVendida)
    {
        super(nome, endereco, telefone, (salario / comissao * qtdeVendida));
    }

}
