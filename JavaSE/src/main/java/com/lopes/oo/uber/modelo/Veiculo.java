package com.lopes.oo.uber.modelo;

public class Veiculo {

	private String marca;
	private String cor;
	private int ano;
	private String placa;
	private Pessoa condutor;

	public Veiculo(String marca, String cor, int ano, String placa, Pessoa condutor) {
		this.marca = marca;
		this.cor = cor;
		this.ano = ano;
		this.placa = placa;
		this.condutor = condutor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Pessoa getCondutor() {
		return condutor;
	}

	public void setCondutor(Pessoa condutor) {
		this.condutor = condutor;
	}

}
