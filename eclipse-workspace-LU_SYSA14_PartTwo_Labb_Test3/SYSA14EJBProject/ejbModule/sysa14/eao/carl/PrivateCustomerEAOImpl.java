package sysa14.eao.carl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import sysa14.entityBeans.carl.PrivateCustomer;

/**
 * Session Bean implementation class PrivateCustomerEAOImpl
 */
@Stateless
public class PrivateCustomerEAOImpl implements PrivateCustomerEAOImplLocal {

    /**
     * Default constructor. 
     */
    public PrivateCustomerEAOImpl() {
        // TODO Auto-generated constructor stub
    }

    @PersistenceContext(unitName="LabEJBSql")
    private EntityManager em; 
    
    public boolean createPrivateCustomer(PrivateCustomer privateCustomer) {
    	boolean condition = true; 
    	try {
    		em.persist(privateCustomer);
    	} catch (Exception e) {
    		condition = false; 
    	}
    	return condition; 
    }
    
    public PrivateCustomer findPrivateCustomerByID(int id) {
    	return em.find(PrivateCustomer.class, id);
    }
    
    public boolean updatePrivateCustomer(PrivateCustomer privateCustomer) {
    	boolean condition = true; 
    	try {
    		em.merge(privateCustomer); 
    	} catch (Exception e) {
    		condition = false; 
    	}
    	return condition; 
    }
    
    public boolean deletePrivateCustomer(PrivateCustomer privateCustomer) {
    	boolean condition = true; 
    	try {
    		em.remove(privateCustomer);
    	} catch (Exception e) {
    		condition = false; 
    	}
    	return condition; 
    }
    
    public boolean checkIfPrivateCustomerExists(int id) {
    	boolean temp = false; 
    	TypedQuery<PrivateCustomer> tq = em.createNamedQuery("PrivateCustomer.checkIfPrivateCustomerExist", PrivateCustomer.class);     
    	tq.setParameter("value", id); 
    	if(!tq.getResultList().isEmpty()) {
    		temp = true; 
    	}
    	// Returns true if the privateCustomer-object exists, else false. 
    	return temp; 
    }
    
    public List<PrivateCustomer> getAllPrivateCustomers(){
    	List<PrivateCustomer> temp = new ArrayList<PrivateCustomer>();
    	TypedQuery<PrivateCustomer> tq = em.createNamedQuery("PrivateCustomer.getAllPrivateCustomoers", PrivateCustomer.class);
    	try {
    		temp = tq.getResultList(); 
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return temp;
    }
}