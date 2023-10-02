package com.lopes.ufersa.exemplo;

public class Retangulo {

    private int altura, largura;

    public Retangulo(int altura, int largura)
    {
        setAltura(altura);
        setLargura(largura);
    }

    public int calculaAltura()
    {
        return getAltura() * getLargura();
    }

    public int calculaPerimetro()
    {
        return (getAltura() * 2) + (getAltura() * 2);
    }

    // Concluir implementação
    public void desenhar()
    {
        for (int i = 1; i <= getAltura(); i++)
        {
            for (int j = 1; j <= getLargura(); j++)
            {
                if (i == 1 || i == getAltura() || (j == 1 || j == getLargura()))
                {
                    if (j == 1)
                        System.out.print("*");
                }
                else
                {
                    System.out.println(" ");
                }

            }
        }
    }

    private boolean ehValido(int valor)
    {
        if (valor < 1)
        {
            System.out.println("Sistema encerrado........");
            System.exit(0);
            return false;
        }
        return true;
    }

    public int getAltura()
    {
        return altura;
    }

    public int getLargura()
    {
        return largura;
    }

    public void setAltura(int altura)
    {
        if (ehValido(altura))
        {
            this.altura = altura;
        }
    }

    public void setLargura(int largura)
    {
        if (ehValido(largura))
        {
            this.largura = largura;
        }

    }

}
