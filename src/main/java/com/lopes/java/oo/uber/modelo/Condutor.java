package com.lopes.java.oo.uber.modelo;

public class Condutor extends Pessoa {

	private String numeroHabilitacao;

	public Condutor(String nome, int idade, char sexo, String telefone, String numeroHabilitacao,
			boolean podePedirUber) {
		super(nome, idade, sexo, telefone, podePedirUber);
		this.numeroHabilitacao = numeroHabilitacao;
	}

	public String getNumeroHabilitacao() {
		return numeroHabilitacao;
	}

	public void setNumeroHabilitacao(String numeroHabilitacao) {
		this.numeroHabilitacao = numeroHabilitacao;
	}

}
