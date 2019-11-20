package com.lopes.java.oo.uber.pagamento;

public class PagamentoCartao implements Pagamento {

	@Override
	public void pagar(double valor) {
		System.out.println("Pagamento de R$ " + valor + " feito no cart�o de cr�dito...");
	}

	@Override
	public double obterValorReal(double valor) {
		valor = valor + (valor * 0.2);
		return valor;
	}

}
