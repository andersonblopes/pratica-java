package com.lopes.java.ordenalistas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoMain {
	public static void main(String[] args) {
		List<Cliente> clientes = new ArrayList<>();

		Cliente c1 = new Cliente("Anderson", 35);
		Cliente c2 = new Cliente("Helena", 8);
		Cliente c3 = new Cliente("Elaine", 29);
		Cliente c4 = new Cliente("Gabriel", 8);

		clientes.add(c1);
		clientes.add(c2);
		clientes.add(c3);
		clientes.add(c4);

		// Lista sem ordenação
		System.out.println(clientes);

		// Utilizando ordenação da própria classe
		// Collections.sort(clientes);/

		// Utilizando o comparador criado
		Collections.sort(clientes, new ComparadorDeClientes());
		// Collections.reverse(clientes);

		// Lista ordenada pelo comparable
		System.out.println(clientes);

	}

}
