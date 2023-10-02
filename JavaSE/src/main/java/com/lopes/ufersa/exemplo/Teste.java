package com.lopes.ufersa.exemplo;

public class Teste {

    public static void main(String args[])
    {
        AlunoPosGraduacao apg = new AlunoPosGraduacao("João", "cet", 123456, "Desocupado");
        AlunoGraduacao ag = new AlunoGraduacao("Anderson", "CC", 90909090, 7.3);
        ag.mostrardados();
        apg.mostrardados();
    }
}
