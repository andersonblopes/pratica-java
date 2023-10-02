package com.lopes.oo.uber.pagamento;

public class PagamentoCheque implements Pagamento {

	@Override
	public void pagar(double valor) {
		System.out.println("Pagamento de R$ " + valor + " feito com cheque...");
	}

	@Override
	public double obterValorReal(double valor) {
		valor = valor + (valor * 0.1);
		return valor;
	}

}
