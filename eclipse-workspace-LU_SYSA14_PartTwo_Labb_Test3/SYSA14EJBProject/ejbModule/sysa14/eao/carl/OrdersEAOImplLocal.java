package sysa14.eao.carl;

import java.util.List;

import javax.ejb.Local;

import sysa14.entityBeans.carl.Orders;

@Local
public interface OrdersEAOImplLocal {
	
	public boolean createOrdersForPrivateCustomer(Orders orders);
	 
    public Orders findByOrdersID(int id);
        
    public boolean deleteOrders(Orders orders); 
    
    public boolean checkIfOrdersExist(int id); 
    
    public List<Orders> getAllOrders(); 

    public List<Orders> getAllOrdersForCustomer(int customerID);

}
