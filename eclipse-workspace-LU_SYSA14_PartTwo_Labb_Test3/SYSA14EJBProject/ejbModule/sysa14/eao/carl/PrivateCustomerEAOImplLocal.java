package sysa14.eao.carl;

import java.util.List;

import javax.ejb.Local;

import sysa14.entityBeans.carl.PrivateCustomer;

@Local
public interface PrivateCustomerEAOImplLocal {

    public boolean createPrivateCustomer(PrivateCustomer privateCustomer);
    
    public PrivateCustomer findPrivateCustomerByID(int id) ;
    
    public boolean updatePrivateCustomer(PrivateCustomer privateCustomer);
    
    public boolean deletePrivateCustomer(PrivateCustomer privateCustomer);
    
    public boolean checkIfPrivateCustomerExists(int id); 

    public List<PrivateCustomer> getAllPrivateCustomers(); 

    
}
