package negocio;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GerenciadoraClientesTest_Ex2 extends AbstractTest{

	@Test
	public void testPesquisaCliente() {
		assertThat(cliente.getId(), is(1));
	}
	
	@Test
	public void testRemoveCliente() {
		boolean clienteRemovido = gerClientes.removeCliente(2);
		assertThat(clienteRemovido, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(2));
	}

}
