package com.lopes.ufersa.avaliacao;

public class TEtanol extends Tanque {

    public TEtanol(int capacidade, int volumeAtual)
    {
        super(capacidade, volumeAtual);
    }

    public TEtanol(String squencial, int capacidade, int volumeAtual)
    {
        super(squencial, capacidade, volumeAtual);
    }

    @Override
    public String toString()
    {
        return "O tanque de etanol de n�mero: " + getSequencial() + ",  tem capacidade de: " + getCapacidade()
                + " litros e est� atualmente com " + getVolumeAtual() + " litros";
    }
}
