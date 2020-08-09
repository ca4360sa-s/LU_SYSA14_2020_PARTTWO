package sysa14.eao.carl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import sysa14.entityBeans.carl.Product_Orders;

/**
 * Session Bean implementation class Product_OrdersEAOImpl
 */
@Stateless
public class Product_OrdersEAOImpl implements Product_OrdersEAOImplLocal {

    /**
     * Default constructor. 
     */
    public Product_OrdersEAOImpl() {
        // TODO Auto-generated constructor stub
    }

    @PersistenceContext(unitName="LabEJBSql")
    private EntityManager em; 
    
    public boolean createProduct_Orders(Product_Orders product_Orders) {
    	boolean condition = true; 
    	try {
    		em.persist(product_Orders);
    	} catch (Exception e) {
    		condition = false; 
    	}
    	return condition; 
    }
    public boolean checkIfOrderAlreadyContainsProduct(int orderID, int productID) {
    	boolean condition = true; 
    	TypedQuery<Product_Orders >tq = em.createNamedQuery("Product_Orders.checkIfOrderAlreadyContainsProduct", Product_Orders.class); 
    	tq.setParameter("productID", productID); 
    	tq.setParameter("orderID", orderID); 
    	if(tq.getResultList().isEmpty()) {
    		condition = false; 
    	}
    	
    	return condition; 
    }
    

}
