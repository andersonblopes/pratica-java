package negocio;

import org.junit.Before;
import org.junit.BeforeClass;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTest {

    protected static Cliente cliente;
    protected GerenciadoraClientes gerClientes;
    private GerenciadoraContas gerContas;

    @Before
    public void setup() {
        Cliente cliente01 = new Cliente(1, "Gustavo Farias", 31, "gugafarias@gmail.com", 1, true);
        Cliente cliente02 = new Cliente(2, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 2, true);
        int idConta01 = 1;
        int idConta02 = 2;
        ContaCorrente conta01 = new ContaCorrente(idConta01, 200, true);
        ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
        List<Cliente> clientesDoBanco = new ArrayList<>();
        clientesDoBanco.add(cliente01);
        clientesDoBanco.add(cliente02);
        gerClientes = new GerenciadoraClientes(clientesDoBanco);
        cliente = gerClientes.pesquisaCliente(1);
    }
}
