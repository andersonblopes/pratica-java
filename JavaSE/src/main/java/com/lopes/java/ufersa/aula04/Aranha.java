package com.lopes.java.ufersa.aula04;

public class Aranha extends Animal {

    public Aranha(int nPernas)
    {
        super(nPernas);
    }

    @Override
    public String come()
    {
        return "Aranha come insetos";
    }
}
