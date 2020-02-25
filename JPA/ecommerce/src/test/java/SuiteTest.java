import com.lopes.ecommerce.test.model.ClientCRUDTest;
import com.lopes.ecommerce.test.model.ProductCRUDTest;
import com.lopes.ecommerce.test.training.relationships.*;
import com.lopes.ecommerce.test.training.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(value = {EmbeddableClassTest.class,
        MappingEnumerationsTest.class,
        ProductPersistTest.class,
        ProductTest.class,
        ProductCRUDTest.class,
        ClientCRUDTest.class,
        CategoryTest.class,
        RelationshipManyToOneTest.class,
        RelationshipOneToManyTest.class,
        SelfRelationshipTest.class,
        RelationshipManyToManyTest.class,
        RelationshipOneToOneTest.class})
public class SuiteTest {
}
