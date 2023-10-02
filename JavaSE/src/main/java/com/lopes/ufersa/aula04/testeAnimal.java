package com.lopes.ufersa.aula04;

public class testeAnimal {

    public static void main(String[] args)
    {
        Aranha a = new Aranha(8);
        System.out.println(a.come());

        Cachorro c = new Cachorro(4, "Marley");
        System.out.println(c.come());

    }

}
