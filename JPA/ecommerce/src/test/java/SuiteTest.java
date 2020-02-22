import com.lopes.ecommerce.test.model.ClientCRUDTest;
import com.lopes.ecommerce.test.model.ProductCRUDTest;
import com.lopes.ecommerce.test.training.ProductPersistTest;
import com.lopes.ecommerce.test.training.ProductTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ProductTest.class, ProductPersistTest.class, ProductCRUDTest.class, ClientCRUDTest.class})
public class SuiteTest {
}
