package com.lopes.ufersa.avaliacao;

public class Funcionario {

    private String nome, cargo, idEmpregado;

    public Funcionario(String nome, String cargo, String idEmpregado)
    {
        setNome(nome);
        setCargo(cargo);
        setIdEmpregado(idEmpregado);
    }

    public String getCargo()
    {
        return cargo;
    }

    public String getIdEmpregado()
    {
        return idEmpregado;
    }

    public String getNome()
    {
        return nome;
    }

    public void setCargo(String cargo)
    {
        this.cargo = cargo;
    }

    public void setIdEmpregado(String idEmpregado)
    {
        this.idEmpregado = idEmpregado;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

}
