package com.lopes.java.oo.uber.modelo;

public class UberBlack extends Uber {

	@Override
	public double getComissao(double valorCorrida) {
		return valorCorrida * 0.40;
	}

}
