package com.lopes.java.oo.uber.pagamento;

public class PagamentoCheque implements Pagamento {

	@Override
	public void pagar(double valor) {
		System.out.println("Pagamento de R$ " + valor + " feito em cheque...");
	}

	@Override
	public double obterValorReal(double valor) {
		valor = valor + (valor * 0.1);
		return valor;
	}

}
