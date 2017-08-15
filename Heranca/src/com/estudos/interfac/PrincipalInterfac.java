package com.estudos.interfac;

public class PrincipalInterfac {

	public static void main(String[] args) {
		GatoImpl gato = new GatoImpl();
		CachorroImpl cachorro = new CachorroImpl();
		animalCominicar(gato);
		animalCominicar(cachorro);
	}

	public static void animalCominicar(IAnimal animal) {
		System.out.println(animal.comunicar());
	}

}
