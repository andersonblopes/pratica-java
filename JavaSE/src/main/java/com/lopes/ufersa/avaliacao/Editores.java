package com.lopes.ufersa.avaliacao;

public class Editores extends Funcionario {

    private String edicao;

    public Editores(String nome, String cargo, String idEmpregado, String edicao)
    {
        super(nome, cargo, idEmpregado);
        this.setEdicao(edicao);
    }

    public String getEdicao()
    {
        return edicao;
    }

    public void setEdicao(String edicao)
    {
        this.edicao = edicao;
    }

}
