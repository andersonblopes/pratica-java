import com.lopes.model.User;
import com.lopes.model.dao.UserDAO;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDAOTest {

    private static Connection connection;

    @BeforeClass
    public static void setup() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud" +
                "?useTimezone=true&serverTimezone=UTC", "root", "root");
    }

    @AfterClass
    public static void clear() throws SQLException {
        connection.close();
    }

    @Test
    public void crud() {
        User user = new User(null, "Anderson Lopes", "anderson","lopes");

        // Criando a instância do DAO.
        UserDAO dao = new UserDAO(connection);

        // Fazendo a inserção e recuperando o identificador.
        Long id = dao.save(user);
        Assert.assertNotNull("Identificador foi retornado como NULL.", id);

        // Atribuindo o identificador retornado ao atributo "id".
        user.setId(id);

        // Verificando se o registro realmente foi para o banco de dados.
        user = dao.findById(user.getId());
        Assert.assertNotNull("Evento nulo.", user);

        // Atualizando o registro no banco de dados.
        String nomeAlterado = user.getName() + " alterado";
        user.setName(nomeAlterado);
        dao.update(user);

        // Verificando se atualização ocorreu com sucesso.
        user = dao.findById(user.getId());
        Assert.assertEquals("O nome não foi atualizado corretamente.", nomeAlterado, user.getName());

        // Removendo o registro.
        dao.delete(user.getId());

        // O registro não existe mais. O método "buscar" deve retornar nulo.
        user = dao.findById(user.getId());
        Assert.assertNull("Evento ainda existe e não deveria.", user);
    }
}
