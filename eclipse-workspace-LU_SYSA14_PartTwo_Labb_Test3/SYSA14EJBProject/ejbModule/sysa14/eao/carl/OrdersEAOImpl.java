package sysa14.eao.carl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import sysa14.entityBeans.carl.Orders;

/**
 * Session Bean implementation class OrdersEAOImpl
 */
@Stateless
public class OrdersEAOImpl implements OrdersEAOImplLocal {

    /**
     * Default constructor. 
     */
    public OrdersEAOImpl() {
        // TODO Auto-generated constructor stub
    }

    @PersistenceContext(unitName="LabEJBSql") 
    private EntityManager em; 
   
	public boolean createOrdersForPrivateCustomer(Orders orders) {
		boolean condition = true; 
		try {
			em.persist(orders);
		} catch (Exception e) {
			condition = false; 
		}
		return condition; 
	}
    
    public Orders findByOrdersID(int id) {
    	return em.find(Orders.class, id);
    }
    
    public boolean deleteOrders(Orders orders) {
    	boolean condition = true; 
    	try {
    		em.remove(orders);
    	} catch (Exception e) {
    		condition = false; 
    	}
    	return condition; 
    }
    
    public boolean checkIfOrdersExist(int id) {
    	boolean temp = false; 
    	try {
    		TypedQuery<Orders> tq = em.createNamedQuery("Orders.checkIfOrdersExist", Orders.class);
        	tq.setParameter("value", id); 
        	if(!tq.getResultList().isEmpty()) {
        		temp = true;
        	}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return temp; 
    } 

    public List<Orders> getAllOrders(){
    	List<Orders> tempList = new ArrayList<Orders>(); 
    	try {
    		TypedQuery<Orders> tq = em.createNamedQuery("Orders.getAllOrders", Orders.class); 
    		tempList = tq.getResultList(); 
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return tempList; 
    }
    
    public List<Orders>getAllOrdersForCustomer(int customerID){
    	List<Orders> tempList = new ArrayList<Orders>(); 
    	try {
    		TypedQuery<Orders> tq = em.createNamedQuery("Orders.getAllOrdersForCustomer", Orders.class); 
    		tq.setParameter("value", customerID); 
    		tempList = tq.getResultList(); 
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return tempList; 
    }

}

