package com.lopes.java;

import java.util.Comparator;

public class ComparadorDeClientes implements Comparator<Cliente> {

	@Override
	public int compare(Cliente c1, Cliente c2) {
		if (c1.getIdade() >= c2.getIdade() && c1.getNome().compareTo(c2.getNome()) < 0) {
			return -1;
		}
		if (c1.getIdade() < c2.getIdade() && c1.getNome().compareTo(c2.getNome()) > 0) {
			return 1;
		}
		return 0;
	}

}
