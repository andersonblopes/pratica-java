package com.lopes.ufersa.exemplo;

public class Contador {

    private int contador;

    public int getContador()
    {
        return contador;
    }

    public void incrementar(int valor)
    {
        this.contador += valor;
    }

    public void zerar()
    {
        this.contador = 0;
    }

}
