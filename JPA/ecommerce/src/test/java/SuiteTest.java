import com.lopes.ecommerce.test.model.ClientCRUDTest;
import com.lopes.ecommerce.test.model.ProductCRUDTest;
import com.lopes.ecommerce.test.training.relationships.RelationshipManyToManyTest;
import com.lopes.ecommerce.test.training.relationships.SelfRelationshipTest;
import com.lopes.ecommerce.test.training.relationships.RelationshipManyToOneTest;
import com.lopes.ecommerce.test.training.relationships.RelationshipOneToManyTest;
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
        RelationshipManyToManyTest.class})
public class SuiteTest {
}
