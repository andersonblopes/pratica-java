package com.lopes.ufersa.exemplo;

public class AlunoPosGraduacao extends Aluno {

    private String linhaPesquisa;

    public AlunoPosGraduacao(String nome, String curso, int matricula, String linhaPesquisa)
    {
        super(nome, curso, matricula);
        this.linhaPesquisa = linhaPesquisa;
    }

    @Override
    public void mostrardados()
    {
        System.out.println(this.getNome() + " é aluno(a) de pós graduação do curso " + this.getCurso()
                + ", da linha de pesquisa " + this.linhaPesquisa);
    }
}
