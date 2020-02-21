package negocio;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GerenciadoraClientesTest_Ex1 extends AbstractTest {

    @Test
    public void testPesquisaCliente() {
        assertThat(cliente.getId(), is(1));
        assertThat(cliente.getEmail(), is("gugafarias@gmail.com"));
    }

}
