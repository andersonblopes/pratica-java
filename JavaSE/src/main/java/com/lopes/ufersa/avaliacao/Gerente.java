package com.lopes.java.ufersa.avaliacao;

import java.util.ArrayList;

public class Gerente extends Funcionario {

    private ArrayList<Funcionario> func;

    public Gerente(String nome, String cargo, String idEmpregado, ArrayList<Funcionario> func)
    {
        super(nome, cargo, idEmpregado);
        this.setFunc(func);
    }

    public ArrayList<Funcionario> getFunc()
    {
        return func;
    }

    public void setFunc(ArrayList<Funcionario> func)
    {
        this.func = func;
    }

}
