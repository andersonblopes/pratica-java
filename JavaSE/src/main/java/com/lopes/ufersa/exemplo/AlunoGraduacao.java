package com.lopes.ufersa.exemplo;

public class AlunoGraduacao extends Aluno {

    private double media;

    public AlunoGraduacao(String nome, String curso, int matricula, double media)
    {
        super(nome, curso, matricula);
        this.media = media;
    }

    @Override
    public void mostrardados()
    {
        System.out.println(this.getNome() + " é aluno(a) do curso " + this.getCurso() + ", tendo média " + this.media);
    }

}
