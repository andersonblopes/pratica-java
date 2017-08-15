package com.estudos.heranca;

public class PrincipalHeranca {

	public static void main(String[] args) {
		Gato gato = new Gato();
		Cachorro cachorro = new Cachorro();
		animalCominicar(gato);
		animalCominicar(cachorro);
	}

	public static void animalCominicar(Animal animal) {
		System.out.println(animal.comunicar());
	}

}
