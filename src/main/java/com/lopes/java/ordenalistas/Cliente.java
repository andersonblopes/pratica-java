package com.lopes.java.ordenalistas;

public class Cliente implements Comparable<Cliente> {

	private String nome;

	private Integer idade;

	public Cliente(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}

	@Override
	public int compareTo(Cliente outroCliente) {
		if (this.idade >= outroCliente.getIdade() && this.getNome().compareTo(outroCliente.getNome()) < 0) {
			return -1;
		}
		if (this.idade < outroCliente.getIdade() && this.getNome().compareTo(outroCliente.getNome()) > 0) {
			return 1;
		}
		return 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", idade=" + idade + "]";
	}

}
