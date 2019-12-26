package com.lopes.java.ufersa.exemplo;

public class Operacoes {

    public static void main(String[] args)
    {
        Operacoes obj = new Operacoes();
        obj.a = 10;
        obj.b = 20;
        System.out.println(obj.operacao1());
        System.out.println(obj.operacao2());
    }

    private int a, b;

    int operacao1()
    {
        return 2 * a + 2 * b;
    }

    int operacao2()
    {
        return a * b;
    }
}
