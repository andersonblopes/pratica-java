package com.lopes.java.ufersa.aula04;

public class testeEmpregado {

    public static void main(String[] args)
    {
        Chefe c = new Chefe("maria", "Q1-08 bloco D, apto 415", 99971234, 3.000);
        System.out.println(c.tooString());

        EmpregadoComissionado ec = new EmpregadoComissionado("João", "rua sem nome denovo", 99999999, 1.000, 0.02,
                3000);
        System.out.println(ec.tooString());

        EmpregadoHorista eh = new EmpregadoHorista("José", "rua sem endereço", 9876543, 30.00, 45);
        System.out.println(eh.tooString());
    }

}
