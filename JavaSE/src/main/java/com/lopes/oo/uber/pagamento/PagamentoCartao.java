package com.lopes.oo.uber.pagamento;

public class PagamentoCartao implements Pagamento {

	@Override
	public void pagar(double valor) {
		System.out.println("Pagamento de R$ " + valor + " feito com cartão de crédito...");
	}

	@Override
	public double obterValorReal(double valor) {
		valor = valor + (valor * 0.2);
		return valor;
	}

}
