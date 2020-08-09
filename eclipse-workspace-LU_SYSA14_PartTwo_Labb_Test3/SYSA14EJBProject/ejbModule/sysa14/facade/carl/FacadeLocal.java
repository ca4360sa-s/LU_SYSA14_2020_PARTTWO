package sysa14.facade.carl;

import java.util.List;

import javax.ejb.Local;

import sysa14.entityBeans.carl.Orders;
import sysa14.entityBeans.carl.PrivateCustomer;
import sysa14.entityBeans.carl.Product;
import sysa14.pojo.carl.ProductSpec;

@Local
public interface FacadeLocal {

	// Product ----------------------------------------------------------------------------------------------------
	
	public int createProduct(String productName, String productDescription, int stockQuantity);
	 
    public Product findProduct(int id);
    
    public boolean updateProductName(int productID, String productName);
    
    public boolean updateProductDescription(int productID, String productDescription);
    
    public boolean updateProductStockQuantity(int productID, int stockQuantity);
    
    public boolean deleteProduct(int id);
    
    public boolean checkIfProductExist(int id);
    
    public int checkStockQuantity(int productID);

    public List<Product> getAllProducts(); 
    
    public List<ProductSpec> displayAllProductsForOrder(int orderID); 


    // Order ------------------------------------------------------------------------------------------------------ 
    
    public int createOrdersForPrivateCustomer (int privateCustomerID);
        
    public Orders findOrders(int orderID); 
    
    public boolean deleteOrders(int orderID);
    
    public List<Orders>	getAllOrders (); 
    
    public List<Orders>	getAllOrdersForCustomer(int customerID); 
    
    // PrivateCustomer --------------------------------------------------------------------------------------------
    
    public int createPrivateCustomer (String firstName, String lastName, String address);
    
    public PrivateCustomer findPrivateCustomer (int customerID);
    
    public boolean updatePrivateCustomerFirstName(int customerID, String firstName);
    
    public boolean updatePrivateCustomerLastName(int customerID, String lastName);
    
    public boolean updatePrivateCustomerAddress(int customerID, String address);
    
    public boolean deletePrivateCustomer(int customerID);
    
    public List<PrivateCustomer> getAllPrivateCustomers();
    
    // Product_Orders ---------------------------------------------------------------------------------------------

    public boolean createProduct_Orders(int productID, int orderID, int quantity); 

}
