package sysa14.junit.carl;
import javax.naming.Context;
import javax.naming.InitialContext; 
import sysa14.facade.carl.FacadeLocal; 
import junit.framework.TestCase;

public class FacadeOrdersBeanTest extends TestCase {
	
	FacadeLocal facade; 

	public FacadeOrdersBeanTest(String name) {
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
	
	public void testCreateOrderAndFindForPrivateCustomer() throws Exception {
		int tempCustomerID = facade.createPrivateCustomer("TempFirstName", "TempLastName", "TempAdress"); 
		int tempOrderID = facade.createOrdersForPrivateCustomer(tempCustomerID);
		assertEquals(facade.findOrders(tempOrderID).getOrderID(), tempOrderID); 
		facade.deleteOrders(tempOrderID);
		facade.deletePrivateCustomer(tempCustomerID);
		
	}
	public void testDeleteOrderForPrivateCustomer() throws Exception {
		int tempCustomerID = facade.createPrivateCustomer("TempFirstName", "TempLastName", "TempAdress"); 
		int tempOrderID = facade.createOrdersForPrivateCustomer(tempCustomerID);
		assertTrue(facade.deleteOrders(tempOrderID));
		facade.deletePrivateCustomer(tempCustomerID);
	}

	
	
}
