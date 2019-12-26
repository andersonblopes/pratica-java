package com.lopes.java.ufersa.aula04;

public class EmpregadoHorista extends Empregado {

    public EmpregadoHorista(String nome, String endereco, int telefone, double valorHora, int qtdeHorasTrabalhadas)
    {
        super(nome, endereco, telefone, qtdeHorasTrabalhadas * valorHora);
    }

}
