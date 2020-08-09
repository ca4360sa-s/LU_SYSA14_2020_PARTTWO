package sysa14.eao.carl;

import javax.ejb.Local;

import sysa14.entityBeans.carl.Product_Orders;

@Local
public interface Product_OrdersEAOImplLocal {

    public boolean createProduct_Orders(Product_Orders product_Orders);
    
    public boolean checkIfOrderAlreadyContainsProduct(int orderID, int productID);

}
