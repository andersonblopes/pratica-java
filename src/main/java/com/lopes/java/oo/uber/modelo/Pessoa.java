package com.lopes.java.oo.uber.modelo;

public class Pessoa {

	private String nome;
	private int idade;
	private char sexo;
	private String telefone;
	private boolean podePedirUber;

	public boolean isPodePedirUber() {
		return podePedirUber;
	}

	public void setPodePedirUber(boolean podePedirUber) {
		this.podePedirUber = podePedirUber;
	}

	public Pessoa(String nome, int idade, char sexo, String telefone, boolean podePedirUber) {
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
		this.telefone = telefone;
		this.podePedirUber = podePedirUber;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
