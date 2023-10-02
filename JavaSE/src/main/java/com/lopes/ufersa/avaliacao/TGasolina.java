package com.lopes.ufersa.avaliacao;

public class TGasolina extends Tanque {

    public TGasolina(int capacidade, int volumeAtual)
    {
        super(capacidade, volumeAtual);
    }

    public TGasolina(String squencial, int capacidade, int volumeAtual)
    {
        super(squencial, capacidade, volumeAtual);
    }

    @Override
    public String toString()
    {
        return "O tanque de Gasolina de número: " + getSequencial() + ",  tem capacidade de: " + getCapacidade()
                + " litros e está atualmente com " + getVolumeAtual() + " litros";
    }
}
