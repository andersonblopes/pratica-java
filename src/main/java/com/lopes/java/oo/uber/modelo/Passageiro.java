package com.lopes.java.oo.uber.modelo;

public class Passageiro extends Pessoa {

	private String cpf;

	public Passageiro(String nome, int idade, char sexo, String telefone, String cpf, boolean podePedirUber) {
		super(nome, idade, sexo, telefone, podePedirUber);
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
