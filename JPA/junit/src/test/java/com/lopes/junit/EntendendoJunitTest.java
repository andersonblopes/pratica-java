package com.lopes.junit;

import org.junit.*;

public class EntendendoJunitTest {

    @BeforeClass
    public static void iniciarTestes(){
        System.out.println(">>>> public static void iniciarTestes() <<<<");
    }

    @Before
    public void iniciarTeste(){
        System.out.println(">>>> public void iniciarTeste() <<<<");
    }

    @Test
    public void deveTestarAlgo(){
        String nome = String.format("%s","Anderson");
        Assert.assertEquals("Anderson",nome);
    }

    @Test
    public void deveTestarOutraCoisa(){
        String nome = String.format("%s","");
        Assert.assertTrue(nome.isEmpty());
    }
    @After
    public void encerrarTeste(){
        System.out.println(">>>> public void encerrarTeste() <<<<");
    }

    @AfterClass
    public static void encerrarTestes(){
        System.out.println(">>>> public static void encerrarTestes() <<<<");
    }
}
