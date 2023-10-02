package com.lopes.ufersa.avaliacao;

public class Q02Teste {

    public static void main(String[] args)
    {
        Cliente c1 = new Cliente();
        c1.setClienteInfo("Anderson", "Rua 50", "3318 9055");
        System.out.println(c1.getClienteInfo());

        Cliente c2 = new Cliente();
        c2.setClienteInfo("lopes", "Rua 200", "3318 98776", "anderson.lopes.2010@gmail.com");
        System.out.println(c2.getClienteInfo());
    }

}
