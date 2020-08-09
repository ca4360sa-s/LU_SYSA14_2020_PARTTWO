package sysa14.eao.carl;

import java.util.List;

import javax.ejb.Local;

import sysa14.entityBeans.carl.Product;
import sysa14.pojo.carl.ProductSpec;

@Local
public interface ProductEAOImplLocal {


    public void createProduct(Product product);
    
    public Product findByProductID(int id);
    
    public void updateProduct(Product product);
   
    public void deleteProduct(Product product);
    
    public boolean checkIfProductExist(int id); 
    
    public int checkStockQuantityForProduct(int id); 
    
	public List<Product> getAllProducts();
	
	public List<ProductSpec> displayAllProductsForOrder(int orderID); 
}
