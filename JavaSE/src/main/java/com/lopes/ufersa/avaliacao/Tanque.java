package com.lopes.ufersa.avaliacao;

public class Tanque {

    private int capacidade, volumeAtual;
    private String sequencial = "n�o informado";

    public Tanque(int capacidade, int volumeAtual)
    {
        this.setCapacidade(capacidade);
        this.setVolumeAtual(volumeAtual);
    }

    public Tanque(String squencial, int capacidade, int volumeAtual)
    {
        this.setSequencial(squencial);
        this.setCapacidade(capacidade);
        this.setVolumeAtual(volumeAtual);
    }

    public void adicionarCombustivel(int valor)
    {
        if (valor + getVolumeAtual() <= getCapacidade())
        {
            setVolumeAtual(getVolumeAtual() + valor);
        }
        else
        {
            System.out.println(
                    "O tanque só suporta adicionar " + (valor - (getCapacidade() - getVolumeAtual())) + " Litros");
        }
    }

    public int getCapacidade()
    {
        return capacidade;
    }

    public String getSequencial()
    {
        return sequencial;
    }

    public int getVolumeAtual()
    {
        return volumeAtual;
    }

    private boolean isTanqueCheio()
    {
        if (getVolumeAtual() == getCapacidade())
            ;
        return true;
    }

    private boolean isTanqueVazio()
    {
        if (getVolumeAtual() == 0)
            ;
        return true;
    }

    public void retiraCombustivel(int valor)
    {
        if (getVolumeAtual() >= valor)
        {
            setVolumeAtual(getVolumeAtual() - valor);
        }
        else
        {
            System.out.println("Valor superior a volume existente...");
        }

    }

    public void setCapacidade(int capacidade)
    {
        this.capacidade = capacidade;
    }

    public void setSequencial(String sequencial)
    {
        this.sequencial = sequencial;
    }

    public void setVolumeAtual(int volumeAtual)
    {
        this.volumeAtual = volumeAtual;
    }

    @Override
    public String toString()
    {
        return "";
    }

}
