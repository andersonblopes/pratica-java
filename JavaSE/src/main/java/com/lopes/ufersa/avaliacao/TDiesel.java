package com.lopes.ufersa.avaliacao;

public class TDiesel extends Tanque {

    public TDiesel(int capacidade, int volumeAtual)
    {
        super(capacidade, volumeAtual);
    }

    public TDiesel(String squencial, int capacidade, int volumeAtual)
    {
        super(squencial, capacidade, volumeAtual);
    }

    public String tooString()
    {
        return "O tanque de diesel de n�mero: " + getSequencial() + ",  tem capacidade de: " + getCapacidade()
                + " litros e est� atualmente com " + getVolumeAtual() + " litros";
    }
}