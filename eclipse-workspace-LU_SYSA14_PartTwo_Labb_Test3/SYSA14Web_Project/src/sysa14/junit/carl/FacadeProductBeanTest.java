package sysa14.junit.carl;
import javax.naming.Context;
import javax.naming.InitialContext; 
import sysa14.facade.carl.FacadeLocal; 
import junit.framework.TestCase;

public class FacadeProductBeanTest extends TestCase {

	FacadeLocal facade; 
	
	public FacadeProductBeanTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		Context context = new InitialContext(); 
		facade = (FacadeLocal)context.lookup("java:app/SYSA14EJBProject/Facade!sysa14.facade.carl.FacadeLocal");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		facade = null; 
	}
	public void testProductCreateAndFindMethod() throws Exception {
		int tempProductID = facade.createProduct("Test_ProduktName", "Test_Beskrivning", 40);
		assertEquals(facade.findProduct(tempProductID).getProductName(), "Test_ProduktName");
		facade.deleteProduct(tempProductID);
	}
	public void testProductExistMethod() throws Exception {
		int tempProductID = facade.createProduct("Test_ProduktName", "Test_Beskrivning", 40);
		assertTrue(facade.checkIfProductExist(tempProductID));
		facade.deleteProduct(tempProductID);
	}
	public void testProductUpdateMethod() throws Exception {
		int tempProductID = facade.createProduct("Test_ProduktName", "Test_Beskrivning", 40);
		assertTrue(facade.updateProductName(tempProductID, "Test2_Produktnamn"));
		facade.deleteProduct(tempProductID);
	}
	public void testProductDeleteMethod() throws Exception {
		int tempProductID = facade.createProduct("Test_ProduktName", "Test_Beskrivning", 40);
		assertTrue(facade.deleteProduct(tempProductID));
	}
	
}
