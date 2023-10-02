package com.lopes.oo.uber.pagamento;

public class PagamentoDinheiro implements Pagamento {

	@Override
	public void pagar(double valor) {
		System.out.println("Pagamento de R$ " + valor + " feito em espécie...");
	}

	@Override
	public double obterValorReal(double valor) {
		valor = valor - (valor * 0.1);
		return valor;
	}

}
