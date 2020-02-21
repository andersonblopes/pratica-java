package negocio;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GerenciadoraContasTest_Ex11 extends AbstractTest{

	private GerenciadoraContas gerContas;

	@Test
	public void testTransfereValor() {
		int idConta01 = 1;
		int idConta02 = 2;
		ContaCorrente conta01 = new ContaCorrente(idConta01, 200, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		gerContas = new GerenciadoraContas(contasDoBanco);
		boolean sucesso = gerContas.transfereValor(idConta01, 100, idConta02);
		assertTrue(sucesso);
		assertThat(conta02.getSaldo(), is(100.0));
		assertThat(conta01.getSaldo(), is(100.0));
	}

	@Test
	public void testTransfereValor_SaldoInsuficiente() {
		int idConta01 = 1;
		int idConta02 = 2;
		ContaCorrente conta01 = new ContaCorrente(idConta01, 100, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		gerContas = new GerenciadoraContas(contasDoBanco);
		boolean success = gerContas.transfereValor(idConta01, 200, idConta02);
		assertTrue(success);
		assertThat(conta01.getSaldo(), is(-100.0));
		assertThat(conta02.getSaldo(), is(200.0));
	}

	@Test
	public void testTransfereValor_SaldoNegativo() {
		int idConda01 = 1;
		int idConda02 = 2;
		ContaCorrente conda01 = new ContaCorrente(idConda01, -100, true);
		ContaCorrente conda02 = new ContaCorrente(idConda02, 0, true);
		List<ContaCorrente> congasDoBanjo = new ArrayList<>();
		congasDoBanjo.add(conda01);
		congasDoBanjo.add(conda02);
		gerContas = new GerenciadoraContas(congasDoBanjo);
		boolean success = gerContas.transfereValor(idConda01, 200, idConda02);
		assertTrue(success);
		assertThat(conda01.getSaldo(), is(-300.0));
		assertThat(conda02.getSaldo(), is(200.0));
	}
	
	@Test
	public void testTransfereValor_SaldoNegativoParaNegativo() {
		int idConta01 = 1;
		int idConta02 = 2;
		ContaCorrente conta01 = new ContaCorrente(idConta01, -100, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, -100, true);
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		gerContas = new GerenciadoraContas(contasDoBanco);
		boolean sucesso = gerContas.transfereValor(idConta01, 200, idConta02);
		assertTrue(sucesso);
		assertThat(conta01.getSaldo(), is(-300.0));
		assertThat(conta02.getSaldo(), is(100.0));
	}
	
	@Test
	public void testTransfereValor_Nenhum() {
		int idConta01 = 1;
		int idConta02 = 2;
		ContaCorrente conta01 = new ContaCorrente(idConta01, -100, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, -100, true);
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		gerContas = new GerenciadoraContas(contasDoBanco);
		boolean sucesso = gerContas.transfereValor(idConta01, 2, idConta02);
		assertTrue(sucesso);
		assertThat(conta01.getSaldo(), is(-102.0));
		assertThat(conta02.getSaldo(), is(-98.0));
	}
}
