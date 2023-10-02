package com.lopes.ufersa.aula02;

public class Pessoa {

    private String nome, sobrenome;

    public Pessoa(String nome, String sobrenom)
    {
        this.nome = nome;
        this.sobrenome = sobrenom;
    }

    public String getNomeCompleto()
    {
        return nome + " " + sobrenome;
    }

}
