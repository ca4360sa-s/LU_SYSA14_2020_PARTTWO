package sysa14.junit.carl;
import javax.naming.Context;
import javax.naming.InitialContext; 
import sysa14.facade.carl.FacadeLocal; 
import junit.framework.TestCase;

public class FacadePrivateCustomerBeanTest extends TestCase {
	FacadeLocal facade; 
	public FacadePrivateCustomerBeanTest(String name) {
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
	
	public void testPrivateCustomerCreateAndFindMethod() throws Exception{
		int tempCustomerID = facade.createPrivateCustomer("Test_Förnamn", "Test_Efternamn", "Test_Adress");
		assertEquals(facade.findPrivateCustomer(tempCustomerID).getFirstName(), "Test_Förnamn"); 
		facade.deletePrivateCustomer(tempCustomerID);
	}

	public void testPrivateCustomerUpdateMethod() throws Exception{
		int tempCustomerID = facade.createPrivateCustomer("Test_Förnamn", "Test_Efternamn", "Test_Adress");
		assertTrue(facade.updatePrivateCustomerFirstName(tempCustomerID, "Test2_Förnamn")); 
		facade.deletePrivateCustomer(tempCustomerID);
	}
	public void testPrivateCustomerDeleteMethod() throws Exception{
		int tempCustomerID = facade.createPrivateCustomer("Test_Förnamn", "Test_Efternamn", "Test_Adress");
		assertTrue(facade.deletePrivateCustomer(tempCustomerID)); 
	}
}
