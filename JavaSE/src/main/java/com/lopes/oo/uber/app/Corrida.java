package com.lopes.oo.uber.app;

import com.lopes.oo.uber.modelo.Pessoa;
import com.lopes.oo.uber.modelo.Uber;
import com.lopes.oo.uber.modelo.Veiculo;
import com.lopes.oo.uber.pagamento.Pagamento;

public class Corrida {

	private Veiculo veiculo;
	private Pessoa pessoa;
	private Uber uber;

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Pessoa getPassageiro() {
		return pessoa;
	}

	public void setPassageiro(Pessoa passageiro) {
		this.pessoa = passageiro;
	}

	public Uber getUber() {
		return uber;
	}

	public void setUber(Uber uber) {
		this.uber = uber;
	}

	public void finalizarCorrida(double valorAPagar, Pagamento pagamento) {
		if (getPassageiro().isPodePedirUber()) {
			double valorFinal = pagamento.obterValorReal(valorAPagar);
			pagamento.pagar(valorFinal);
			System.out.println("Comissão do condutor: " + getVeiculo().getCondutor().getNome() + " foi de: R$ "
					+ getUber().getComissao(valorFinal));
		} else {
			System.out.println("Que absurdo....");
		}

	}

}
