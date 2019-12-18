package com.lopes.java.ufersa.aula04;

public class Cachorro extends Animal {

    private String nomeCachorro;

    public Cachorro(int nPernas)
    {
        super(nPernas);
    }

    public Cachorro(int nPernas, String nomeCachoro)
    {
        super(nPernas);
        setNomeCachorro(nomeCachoro);
    }

    public String brinca()
    {
        return "O " + getNomeCachorro() + " gosta de brincar com a bola";
    }

    @Override
    public String come()
    {
        return "O " + getNomeCachorro() + " � um cachorro e come carne.";
    }

    public String getNomeCachorro()
    {
        return nomeCachorro;
    }

    public void setNomeCachorro(String nomeCachorro)
    {
        this.nomeCachorro = nomeCachorro;
    }
}
