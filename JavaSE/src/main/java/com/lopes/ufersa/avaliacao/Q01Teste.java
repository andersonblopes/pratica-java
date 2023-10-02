package com.lopes.ufersa.avaliacao;

public class Q01Teste {

    public static void main(String[] args)
    {
        Conta cn = new Conta(500.00);
        cn.sacar(10.00);
        System.out.println(cn.getSaldo());

        ContaEspecial ce = new ContaEspecial(300.00);
        {
            ce.sacar(10.00);
            System.out.println(ce.getSaldo());
        }
    }

}
