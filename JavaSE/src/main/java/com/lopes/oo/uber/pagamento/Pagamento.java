package com.lopes.oo.uber.pagamento;

public interface Pagamento {

	void pagar(double valor);

	double obterValorReal(double valor);

}
