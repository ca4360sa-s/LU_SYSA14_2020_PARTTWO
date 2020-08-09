package sysa14.facade.carl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import sysa14.eao.carl.OrdersEAOImplLocal;
import sysa14.eao.carl.PrivateCustomerEAOImplLocal;
import sysa14.eao.carl.ProductEAOImplLocal;
import sysa14.eao.carl.Product_OrdersEAOImplLocal;
import sysa14.entityBeans.carl.Orders;
import sysa14.entityBeans.carl.PrivateCustomer;
import sysa14.entityBeans.carl.Product;
import sysa14.entityBeans.carl.Product_Orders;
import sysa14.pojo.carl.ProductSpec;

/**
 * Session Bean implementation class Facade
 */
@Stateless
public class Facade implements FacadeLocal {

	@EJB
	private ProductEAOImplLocal productEAO; 
	
	@EJB
	private Product_OrdersEAOImplLocal product_OrdersEAO; 
	
	@EJB
	private OrdersEAOImplLocal ordersEAO; 
	
	@EJB
	private PrivateCustomerEAOImplLocal privateCustomerEAO; 
	
    /**
     * Default constructor. 
     */
    public Facade() {
        // TODO Auto-generated constructor stub
    }

    // Product -------------------------------------------------------------------------------------------------------
    
    public int createProduct(String productName, String productDescription, int stockQuantity) {
    	int condition = 0; 
    	int generatedProductID; 
    	do {
    		generatedProductID = (int)(Math.random()*(2000) +4000); 
    	} while (privateCustomerEAO.checkIfPrivateCustomerExists(generatedProductID)); 
    	
    	if(!productEAO.checkIfProductExist(generatedProductID)) {
        	Product product = new Product(); 
    		product.setProductID(generatedProductID);
    		product.setProductName(productName);
    		product.setProductDescription(productDescription);
    		product.setStockQuantity(stockQuantity);	
    		productEAO.createProduct(product);
    		condition = generatedProductID; 
    	}; 
    	// Returns false if the product already exists, else returns true after creating product. 
    	return condition; 
    }
    
    public Product findProduct(int id) {
    	Product temp = new Product(); 
    	if(productEAO.findByProductID(id) != null) {
    		return productEAO.findByProductID(id); 
    	} else {
        	// returns the product-object if it is found, else an empty product-object. 
    		return temp; 
    	} 	
    }
    
    public boolean updateProductName(int productID, String productName) {
    	boolean condition = false; 
    	Product product = productEAO.findByProductID(productID);
    	if(product != null) {
    		product.setProductName(productName);
    		productEAO.updateProduct(product);
    		condition = true; 
    	}
    	return condition; 
    }
    
    public boolean updateProductDescription(int productID, String productDescription) {
    	
    	boolean condition = false; 
    	Product product = productEAO.findByProductID(productID);
    	if(product != null) {
    		product.setProductDescription(productDescription);
    		productEAO.updateProduct(product);
    		condition = true; 
    	}
    	return condition; 
    }
    
    public boolean updateProductStockQuantity(int productID, int stockQuantity) {
    	boolean condition = false; 
    	Product product = productEAO.findByProductID(productID);
    	if(product != null) {

    		product.setStockQuantity(stockQuantity);
    		productEAO.updateProduct(product);
    		condition = true; 
    	}
    	return condition; 
    }
    
    public boolean deleteProduct(int id) {
    	boolean temp = false; 
    	if(productEAO.checkIfProductExist(id)) {
    		productEAO.deleteProduct(productEAO.findByProductID(id));
    		temp = true; 
    	}
    	// Returns false if the product didn't exist, else returns true after deleting the product. 
    	return temp; 
    }
    
    public boolean checkIfProductExist(int id) {
    	return productEAO.checkIfProductExist(id); 
    }
    
    public int checkStockQuantity(int productID) {
    	int temp = 0; 
    	if(productEAO.checkIfProductExist(productID)) {
    		temp = productEAO.checkStockQuantityForProduct(productID);
    	}
    	return temp; 
    }
    
    public List<Product> getAllProducts(){
    	return productEAO.getAllProducts();
    }
    
    public List<ProductSpec> displayAllProductsForOrder(int orderID){
    	List<ProductSpec> productSpec = new ArrayList<ProductSpec>(); 
    	if(ordersEAO.checkIfOrdersExist(orderID)) {
    		productSpec = productEAO.displayAllProductsForOrder(orderID); 
    	}
    	return productSpec; 
    }
    
    
    // Orders ---------------------------------------------------------------------------------------------------------
    
    public int createOrdersForPrivateCustomer (int privateCustomerID) {
    	int condition = 0; 
    	
    	int generatedOrderID; 
    	do {
    		generatedOrderID = (int)(Math.random()*(2000) +7000); 
    	} while (ordersEAO.checkIfOrdersExist(generatedOrderID)); 
    	
    	if(!ordersEAO.checkIfOrdersExist(generatedOrderID)) {
    		System.out.print("Facade: orderID - OK");
    		if(privateCustomerEAO.checkIfPrivateCustomerExists(privateCustomerID)) {
    			System.out.print("Facade: privateCustomerID - OK ");
        		Orders orders = new Orders(); 
        		orders.setOrderID(generatedOrderID);
        		orders.setPrivateCustomerID(privateCustomerID);
        		if(ordersEAO.createOrdersForPrivateCustomer(orders)) {
        			condition = generatedOrderID; 
        		}
    		}
    	}
    	//Returns the new orderID if the creation was successful, else returns zero (then the orderID or privateCustomerID already exists). 
    	return condition; 
    }
    
    public Orders findOrders(int orderID) {
    	Orders orders = new Orders(); 
    	if(ordersEAO.checkIfOrdersExist(orderID)) {
    		return ordersEAO.findByOrdersID(orderID); 
    	} else {
        	// returns the orders-object if it is found, else an empty orders-object. 
    		return orders; 
    	}
    }
    
    public boolean deleteOrders(int orderID) {
    	boolean condition = false; 
    	if(ordersEAO.checkIfOrdersExist(orderID)) {
    		//Adjusting the stockQuantity before delete.
    		List<ProductSpec> tempProductSpec = productEAO.displayAllProductsForOrder(orderID);
    		for (ProductSpec ps : tempProductSpec) {
    			Product tempProduct = productEAO.findByProductID(ps.getProductID());
    			tempProduct.setStockQuantity(tempProduct.getStockQuantity()+ps.getQuantity());
    			productEAO.updateProduct(tempProduct);
    		}
    		condition = ordersEAO.deleteOrders(ordersEAO.findByOrdersID(orderID));
    	}
    	return condition; 
    }
    
    public List<Orders> getAllOrders(){
    	return ordersEAO.getAllOrders(); 
    }
    
    public List<Orders>	getAllOrdersForCustomer(int customerID){
    	List<Orders> temp = new ArrayList<Orders>(); 
    	if(privateCustomerEAO.checkIfPrivateCustomerExists(customerID)) {
    		temp = ordersEAO.getAllOrdersForCustomer(customerID); 
    	}
    	return temp; 
    }
    
    // Customer (PrivateCustomer) ---------------------------------------------------------------------------------------
    
    public int createPrivateCustomer (String firstName, String lastName, String address) {
    	int condition = 0; 
    	int generatedCustomerID; 
    	do {
    		generatedCustomerID = (int)(Math.random()*(2000) +1000); 
    	} while (privateCustomerEAO.checkIfPrivateCustomerExists(generatedCustomerID)); 
    	
    	if(!privateCustomerEAO.checkIfPrivateCustomerExists(generatedCustomerID)) {
    		PrivateCustomer privateCustomer = new PrivateCustomer(); 
    		privateCustomer.setCustomerID(generatedCustomerID);
    		privateCustomer.setFirstName(firstName);
    		privateCustomer.setLastName(lastName);
    		privateCustomer.setAddress(address);
    		privateCustomerEAO.createPrivateCustomer(privateCustomer);
    		condition = generatedCustomerID; 
    	}
    	// Returns true if the customerID was created successfully, else false. 
    	return condition; 
    }
    
    public PrivateCustomer findPrivateCustomer (int customerID) {
    	PrivateCustomer privateCustomer = new PrivateCustomer(); 
    	if(privateCustomerEAO.checkIfPrivateCustomerExists(customerID)) {
    		privateCustomer = privateCustomerEAO.findPrivateCustomerByID(customerID); 
    	}
    	// Returns the privateCustomer-object if it exists, else an empty object. 
    	return privateCustomer; 
    }
    
    public boolean updatePrivateCustomerFirstName(int customerID, String firstName) {
    	boolean condition = false; 
    	if(privateCustomerEAO.checkIfPrivateCustomerExists(customerID)) {
    		PrivateCustomer privateCustomer = privateCustomerEAO.findPrivateCustomerByID(customerID); 
    		privateCustomer.setFirstName(firstName);
    		condition = privateCustomerEAO.updatePrivateCustomer(privateCustomer);
    	}
    	// Return true if the update was successful, else false;  
    	return condition; 
    }
    
    public boolean updatePrivateCustomerLastName(int customerID, String lastName) {
    	boolean condition = false; 
    	if(privateCustomerEAO.checkIfPrivateCustomerExists(customerID)) {
    		PrivateCustomer privateCustomer = privateCustomerEAO.findPrivateCustomerByID(customerID);  
    		privateCustomer.setLastName(lastName);
    		condition = privateCustomerEAO.updatePrivateCustomer(privateCustomer);
    	}
    	// Return true if the update was successful, else false;  
    	return condition; 
    }
    
    public boolean updatePrivateCustomerAddress(int customerID, String address) {
    	boolean condition = false; 
    	if(privateCustomerEAO.checkIfPrivateCustomerExists(customerID)) {
    		PrivateCustomer privateCustomer = privateCustomerEAO.findPrivateCustomerByID(customerID); 
    		privateCustomer.setAddress(address);
    		condition = privateCustomerEAO.updatePrivateCustomer(privateCustomer);
    	}
    	// Return true if the update was successful, else false;  
    	return condition; 
    }
    
    public boolean deletePrivateCustomer(int customerID) {
    	boolean condition = false; 
    	if(privateCustomerEAO.checkIfPrivateCustomerExists(customerID)) {
    		condition = privateCustomerEAO.deletePrivateCustomer(privateCustomerEAO.findPrivateCustomerByID(customerID)); 
    	}
    	return condition; 
    }
    
    public List<PrivateCustomer> getAllPrivateCustomers(){
    	return privateCustomerEAO.getAllPrivateCustomers(); 
    }
    
    // Generating orders with products for customer (Product_Orders) ----------------------------------------------------
    
    public boolean createProduct_Orders(int productID, int orderID, int quantity) {
    	boolean condition = false; 
    	if(productEAO.checkIfProductExist(productID) && ordersEAO.checkIfOrdersExist(orderID)) {
    		if(quantity<=productEAO.checkStockQuantityForProduct(productID)) {
    			if(!product_OrdersEAO.checkIfOrderAlreadyContainsProduct(orderID, productID)) {
            		Product_Orders product_Orders = new Product_Orders(); 
            		product_Orders.setProductID(productID);
            		product_Orders.setOrderID(orderID);
            		product_Orders.setQuantity(quantity);
            		
            		//Adjust stock quantity of the product
            		Product tempProduct = productEAO.findByProductID(productID); 
            		tempProduct.setStockQuantity(tempProduct.getStockQuantity()-quantity);
            		productEAO.updateProduct(tempProduct);
            		
            		condition = product_OrdersEAO.createProduct_Orders(product_Orders); 
    			}			
    		}	
    	}
    	// Returns true if the Product_Orders-object was created successfully. 
    	return condition; 
    }
}
