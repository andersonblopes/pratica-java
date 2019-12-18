package com.lopes.java.ufersa.avaliacao;

public class Cliente {

    private String nome, endereco, telefone, email = "";

    public String getClienteInfo()
    {
        return nome + " " + endereco + " " + telefone + " " + email;
    }

    public void setClienteInfo(String nome, String endereco, String telefone)
    {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public void setClienteInfo(String nome, String endereco, String telefone, String email)
    {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

}
