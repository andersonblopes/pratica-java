package com.lopes.java.ufersa.exemplo;

public class Aluno {

    private int matricula;
    private String nome, curso;

    public Aluno()
    {

    }

    public Aluno(String nome, String curso, int matricula)
    {
        this.nome = nome;
        this.curso = curso;
        this.matricula = matricula;
    }

    public String getCurso()
    {
        return curso;
    }

    public int getMatricula()
    {
        return matricula;
    }

    public String getNome()
    {
        return nome;
    }

    public void mostrardados()
    {

    }
}
