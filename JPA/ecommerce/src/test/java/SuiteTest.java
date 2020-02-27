import com.lopes.ecommerce.test.model.ClientCRUDTest;
import com.lopes.ecommerce.test.model.ProductCRUDTest;
import com.lopes.ecommerce.test.training.CategoryTest;
import com.lopes.ecommerce.test.training.EmbeddableClassTest;
import com.lopes.ecommerce.test.training.MappingEnumerationsTest;
import com.lopes.ecommerce.test.training.ProductPersistTest;
import com.lopes.ecommerce.test.training.ProductTest;
import com.lopes.ecommerce.test.training.relationships.RelationshipManyToManyTest;
import com.lopes.ecommerce.test.training.relationships.RelationshipManyToOneTest;
import com.lopes.ecommerce.test.training.relationships.RelationshipOneToManyTest;
import com.lopes.ecommerce.test.training.relationships.RelationshipOneToOneTest;
import com.lopes.ecommerce.test.training.relationships.SelfRelationshipTest;
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
