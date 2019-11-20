package com.lopes.java.oo.uber.modelo;

public class UberNormal extends Uber {

	@Override
	public double getComissao(double valorCorrida) {
		return valorCorrida * 0.10;
	}

}
