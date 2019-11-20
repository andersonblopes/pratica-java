package com.lopes.java.oo.uber;

import com.lopes.java.oo.uber.app.Corrida;
import com.lopes.java.oo.uber.modelo.Condutor;
import com.lopes.java.oo.uber.modelo.Passageiro;
import com.lopes.java.oo.uber.modelo.Pessoa;
import com.lopes.java.oo.uber.modelo.UberBlack;
import com.lopes.java.oo.uber.modelo.UberNormal;
import com.lopes.java.oo.uber.modelo.Veiculo;
import com.lopes.java.oo.uber.pagamento.PagamentoCheque;
import com.lopes.java.oo.uber.pagamento.PagamentoDinheiro;

public class Uber {

	public static void main(String[] args) {

		System.out.println("============================================================");
		System.out.println("CORRIDA 1");
		System.out.println("============================================================");
		Corrida c1 = new Corrida();
		c1.setUber(new UberBlack());
		Pessoa passageiro = new Passageiro("João", 60, 'F', "98852=6320", "111.111.111-11", true);
		Pessoa condutor = new Condutor("Renato Maia", 34, 'M', "88888-9090", "123456789", false);
		Veiculo veiculo = new Veiculo("BMW", "Rosa", 2016, "XYZ=1234", condutor);
		c1.setPassageiro(passageiro);
		c1.setVeiculo(veiculo);
		c1.finalizarCorrida(35.0, new PagamentoCheque());
		System.out.println("------------------------------------------------------------");

		System.out.println("============================================================");
		System.out.println("CORRIDA 2");
		System.out.println("============================================================");
		Corrida c2 = new Corrida();
		c2.setUber(new UberNormal());
		Pessoa passageiro2 = new Passageiro("Maria", 30, 'F', "98852=2220", "111.000.111-11", false);
		Pessoa condutor2 = new Condutor("Fábio Paiva", 34, 'M', "81188-9090", "123356789", false);
		Veiculo veiculo2 = new Veiculo("BMW", "Rosa", 2016, "XDF=5513", condutor2);
		c2.setPassageiro(passageiro2);
		c2.setVeiculo(veiculo2);
		c2.finalizarCorrida(100.0, new PagamentoDinheiro());
		System.out.println("------------------------------------------------------------");

	}

}
