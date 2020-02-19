package com.lopes.java.ufersa.aula04;

public class Animal {

    private int nPernas;

    public Animal(int nPernas)
    {
        this.setnPernas(nPernas);
    }

    public String caminha()
    {
        return "caminha com " + getnPernas() + " pernas.";
    }

    public String come()
    {
        return "";
    }

    public int getnPernas()
    {
        return nPernas;
    }

    public void setnPernas(int nPernas)
    {
        this.nPernas = nPernas;
    }

}
