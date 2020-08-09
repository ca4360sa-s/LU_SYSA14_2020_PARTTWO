package sysa14.eao.carl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import sysa14.entityBeans.carl.*;
import sysa14.pojo.carl.ProductSpec;

/**
 * Session Bean implementation class ProductEAOImpl
 */
@Stateless
public class ProductEAOImpl implements ProductEAOImplLocal {
	
    /**
     * Default constructor. 
     */
    public ProductEAOImpl() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName="LabEJBSql")
	private EntityManager em;
    
    //--------------CRUD-METHODS-------------------------------------
    
    public void createProduct(Product product) {
    	em.persist(product);
    }
    
    public Product findByProductID(int id) {
    	return  em.find(Product.class, id);
    }
    
    public void updateProduct(Product product) {
    	em.merge(product);
    }
    
    public void deleteProduct(Product product) {
    	em.remove(product);
    }

	public boolean checkIfProductExist(int id) {
		boolean temp = false; 
		TypedQuery<Product> tq = em.createNamedQuery("Product.checkIfProductExist", Product.class);
		tq.setParameter("value", id); 
		if(!tq.getResultList().isEmpty()) {
			temp = true; 
		}
		return temp;
	}

	public int checkStockQuantityForProduct(int id) {
		Product product = em.find(Product.class, id);
		return product.getStockQuantity();
	}
	
	public List<Product> getAllProducts(){
		List<Product> tempList = new ArrayList<Product>(); 
		try {
			TypedQuery<Product> tq = em.createNamedQuery("Product.getAllProducts", Product.class);
			tempList = tq.getResultList(); 
		} catch (Exception e) {
			System.out.println(e.getStackTrace()); 
		}
		return tempList; 
	}
    
	public List<ProductSpec> displayAllProductsForOrder(int orderID) {
		Query q = em.createNativeQuery("SELECT p.productID, p.productName, p.productDescription, po.quantity "
				+ "FROM Product p JOIN Product_Orders AS po ON p.productID = po.productID WHERE po.orderID = :value", "ProductSpecMapping");	
		q.setParameter("value", orderID); 
		@SuppressWarnings("unchecked")
		List<ProductSpec> temp = q.getResultList(); 
		return temp; 
	}
	
}
